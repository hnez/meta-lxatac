#!/usr/bin/env python3

from tempfile import TemporaryDirectory
import re
import os.path
import subprocess

import yaml
from jinja2 import Environment, FileSystemLoader, StrictUndefined


BRANCH_PRIORITIES = tuple(
    (re.compile(pattern), prio)
    for pattern, prio in (
        ("main", 9999),
        ("master", 9998),
        ("release.*", 9997),
        ("stable.*", 9996),
        (".*release", 9995),
        (".*stable", 9994),
        ("bugfix.*", 6001),
        ("hotfix.*", 6000),
        # The default is 5000
        ("next", 4003),
        ("develop", 4002),
        ("staging", 4001),
        ("feature.*", 4000),
        (".*/.*", 2000),
    )
)


def semver_key(pv):
    return tuple(int(n) for n in pv.split("."))


def branch_key(name):
    for pattern, prio in BRANCH_PRIORITIES:
        if pattern.fullmatch(name):
            return (prio, name)

    return (5000, name)


def run(cmd, capture=True):
    stdout = subprocess.PIPE if capture else None
    return subprocess.run(cmd, stdout=stdout, check=True, text=True).stdout


def fetch_git_branch(info):
    url = info["url"]
    branch = info["branch"]

    with TemporaryDirectory() as dir:
        git_dir = os.path.join(dir, "repo.git")
        git = ["git", "-C", git_dir]

        run(["git", "clone", "--bare", "--filter=blob:none", url, git_dir], False)

        commit_hash = run([*git, "rev-parse", f"refs/heads/{branch}"]).strip()
        commit_date = run([*git, "log", "-1", "--format=%ci", commit_hash]).strip()

        try:
            info["describe"] = run([*git, "describe", "--tags", branch]).strip()
        except subprocess.CalledProcessError:
            pass

    version_pattern = info.get("version_pattern")
    version = re.match(version_pattern, info["describe"])[1] if version_pattern else ""

    info["pv"] = f"{version}+git" if version else ""
    info["commit_hash"] = commit_hash
    info["commit_date"] = commit_date


def fetch_git_tag(info):
    url = info["url"]
    version_pattern = re.compile(info["version_pattern"])

    tags = list()

    with TemporaryDirectory() as dir:
        git_dir = os.path.join(dir, "repo.git")
        git = ["git", "-C", git_dir]

        run(["git", "clone", "--bare", "--filter=blob:none", url, git_dir], False)

        tag_names = run([*git, "tag", "--list"]).strip()
        tag_names = list(tag.strip() for tag in tag_names.split("\n"))

        for name in tag_names:
            hash = run([*git, "rev-parse", f"refs/tags/{name}^{{commit}}"]).strip()
            date = run([*git, "log", "-1", "--format=%ci", hash]).strip()
            timestamp = run([*git, "log", "-1", "--format=%ct", hash]).strip()

            timestamp = int(timestamp)

            branches = run(
                [*git, "branch", "--format=%(refname:lstrip=2)", "--contains", hash]
            ).strip()
            branches = list(branch.strip() for branch in branches.split("\n"))

            branch = max(branches, key=branch_key)

            tags.append(
                {
                    "name": name,
                    "hash": hash,
                    "date": date,
                    "timestamp": timestamp,
                    "branches": branches,
                    "branch": branch,
                }
            )

    versions = dict()

    for tag in tags:
        version_match = version_pattern.match(tag["name"])

        if version_match is None:
            continue

        pv = version_match[1]
        versions[pv] = tag

    if info["version_order"] == "semver":
        newest = max(versions, key=semver_key)
    elif info["version_order"] == "commit date":
        newest = max(versions, key=lambda v: versions[v]["timestamp"])

    info["tag"] = versions[newest]
    info["pv"] = newest


def fetch_info(recipe_info):
    if "git_branch" in recipe_info:
        fetch_git_branch(recipe_info["git_branch"])
        recipe_info["source"] = recipe_info["git_branch"]

    elif "git_tag" in recipe_info:
        fetch_git_tag(recipe_info["git_tag"])
        recipe_info["source"] = recipe_info["git_tag"]


def write_recipe(recipe_info, jinja_env):
    template = jinja_env.get_template(recipe_info["template"])

    recipe_bb = template.render(info=recipe_info)
    recipe_path = recipe_info["recipe"].replace("$PV", recipe_info["source"]["pv"])
    recipe_dir = os.path.dirname(recipe_path)

    os.makedirs(recipe_dir, exist_ok=True)

    with open(recipe_path, "w") as fd:
        fd.write(recipe_bb)

    print(f"Wrote {recipe_path}")


def main(argv):
    config_path = argv[1]
    config_dir = os.path.dirname(config_path)

    with open(argv[1]) as fd:
        config = yaml.safe_load(fd)

    jinja_env = Environment(
        loader=FileSystemLoader(config_dir),
        undefined=StrictUndefined,
        trim_blocks=True,
        lstrip_blocks=True,
    )

    for recipe in config["recipes"]:
        print(f"\n\nGenerate: {recipe['recipe']}")

        fetch_info(recipe)
        write_recipe(recipe, jinja_env)

        print("done")


if __name__ == "__main__":
    import sys

    main(sys.argv)
