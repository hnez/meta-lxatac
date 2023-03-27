SRC_URI = " \
    git://git@github.com/hnez/tacd.git;protocol=ssh;branch=gen2 \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    "

PV = "0.1.0+git${SRCPV}"
SRCREV = "52c09b426528a2045bbef7367787886328ffd79c"

S = "${WORKDIR}/git/web"

inherit npm

# Remove the runtime dependency on nodejs. We only use it during the
# build process to generate static html, js and css files.
RDEPENDS:${PN}:remove = "nodejs"

WEBUI_INSTALL_DIR="${NPM_BUILD}/lib/node_modules/tacd-web"

npm_run_build () {
    cd "${WEBUI_INSTALL_DIR}"
    npm run build
}

do_compile:append() {
    bb.build.exec_func("npm_run_build", d)
}

do_install() {
    install -d "${D}${datadir}/tacd"
    cp -r "${WEBUI_INSTALL_DIR}/build" "${D}${datadir}/tacd/webui"
}

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = " \
    file://../LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

FILES:${PN} = "${datadir}/tacd"
