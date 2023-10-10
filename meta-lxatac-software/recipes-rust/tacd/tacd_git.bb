inherit cargo

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"
SRCREV = "9d58ed271ea4a7e5ef6299885cad07c51c69c3d0"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV = "0.1.0+git${SRCPV}"

SRC_URI += " \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/aead/0.3.2 \
    crate://crates.io/aes-gcm/0.8.0 \
    crate://crates.io/aes-soft/0.6.4 \
    crate://crates.io/aes/0.6.0 \
    crate://crates.io/aesni/0.10.0 \
    crate://crates.io/aho-corasick/1.0.1 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/anyhow/1.0.71 \
    crate://crates.io/arrayref/0.3.7 \
    crate://crates.io/arrayvec/0.5.2 \
    crate://crates.io/async-attributes/1.1.2 \
    crate://crates.io/async-broadcast/0.5.1 \
    crate://crates.io/async-channel/1.8.0 \
    crate://crates.io/async-dup/1.2.2 \
    crate://crates.io/async-executor/1.5.1 \
    crate://crates.io/async-fs/1.6.0 \
    crate://crates.io/async-global-executor/2.3.1 \
    crate://crates.io/async-h1/2.3.3 \
    crate://crates.io/async-io/1.13.0 \
    crate://crates.io/async-lock/2.7.0 \
    crate://crates.io/async-process/1.7.0 \
    crate://crates.io/async-recursion/1.0.4 \
    crate://crates.io/async-session/2.0.1 \
    crate://crates.io/async-sse/4.1.0 \
    crate://crates.io/async-sse/5.1.0 \
    crate://crates.io/async-std/1.12.0 \
    crate://crates.io/async-task/4.4.0 \
    crate://crates.io/async-trait/0.1.68 \
    crate://crates.io/async-tungstenite/0.20.0 \
    crate://crates.io/atomic-waker/1.1.1 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/az/1.2.1 \
    crate://crates.io/base-x/0.2.11 \
    crate://crates.io/base64/0.12.3 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/base64/0.21.0 \
    crate://crates.io/bincode/1.3.3 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitvec/1.0.1 \
    crate://crates.io/blake3/0.3.8 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/block-buffer/0.9.0 \
    crate://crates.io/blocking/1.3.1 \
    crate://crates.io/build-env/0.3.1 \
    crate://crates.io/bumpalo/3.12.2 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/bytes/1.4.0 \
    crate://crates.io/cc/1.0.79 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/chrono/0.4.24 \
    crate://crates.io/cipher/0.2.5 \
    crate://crates.io/codespan-reporting/0.11.1 \
    crate://crates.io/concurrent-queue/2.2.0 \
    crate://crates.io/config/0.10.1 \
    crate://crates.io/const_fn/0.4.9 \
    crate://crates.io/constant_time_eq/0.1.5 \
    crate://crates.io/cookie/0.14.4 \
    crate://crates.io/core-foundation-sys/0.8.4 \
    crate://crates.io/cpufeatures/0.2.7 \
    crate://crates.io/cpuid-bool/0.2.0 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crossbeam-queue/0.3.8 \
    crate://crates.io/crossbeam-utils/0.8.15 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/crypto-mac/0.10.1 \
    crate://crates.io/crypto-mac/0.8.0 \
    crate://crates.io/cstr-argument/0.1.2 \
    crate://crates.io/ctor/0.1.26 \
    crate://crates.io/ctr/0.6.0 \
    crate://crates.io/cxx-build/1.0.94 \
    crate://crates.io/cxx/1.0.94 \
    crate://crates.io/cxxbridge-flags/1.0.94 \
    crate://crates.io/cxxbridge-macro/1.0.94 \
    crate://crates.io/dashmap/5.4.0 \
    crate://crates.io/deadpool/0.7.0 \
    crate://crates.io/derivative/2.2.0 \
    crate://crates.io/digest/0.10.6 \
    crate://crates.io/digest/0.9.0 \
    crate://crates.io/discard/1.0.4 \
    crate://crates.io/embedded-graphics-core/0.3.3 \
    crate://crates.io/embedded-graphics/0.7.1 \
    crate://crates.io/enumflags2/0.7.7 \
    crate://crates.io/enumflags2_derive/0.7.7 \
    crate://crates.io/env_logger/0.10.0 \
    crate://crates.io/erased-serde/0.3.25 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/errno/0.3.1 \
    crate://crates.io/evdev/0.12.1 \
    crate://crates.io/event-listener/2.5.3 \
    crate://crates.io/fastrand/1.9.0 \
    crate://crates.io/fdeflate/0.3.0 \
    crate://crates.io/femme/2.2.1 \
    crate://crates.io/flate2/1.0.26 \
    crate://crates.io/float-cmp/0.8.0 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/foreign-types-macros/0.2.3 \
    crate://crates.io/foreign-types-shared/0.3.1 \
    crate://crates.io/foreign-types/0.5.0 \
    crate://crates.io/form_urlencoded/1.1.0 \
    crate://crates.io/framebuffer/0.3.1 \
    crate://crates.io/funty/2.0.0 \
    crate://crates.io/futures-channel/0.3.28 \
    crate://crates.io/futures-core/0.3.28 \
    crate://crates.io/futures-executor/0.3.28 \
    crate://crates.io/futures-io/0.3.28 \
    crate://crates.io/futures-lite/1.13.0 \
    crate://crates.io/futures-macro/0.3.28 \
    crate://crates.io/futures-sink/0.3.28 \
    crate://crates.io/futures-task/0.3.28 \
    crate://crates.io/futures-util/0.3.28 \
    crate://crates.io/futures/0.3.28 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getrandom/0.1.16 \
    crate://crates.io/getrandom/0.2.9 \
    crate://crates.io/ghash/0.3.1 \
    crate://crates.io/gloo-timers/0.2.6 \
    crate://crates.io/gpio-cdev/0.5.1 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/hermit-abi/0.2.6 \
    crate://crates.io/hermit-abi/0.3.1 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hkdf/0.10.0 \
    crate://crates.io/hmac/0.10.1 \
    crate://crates.io/hmac/0.8.1 \
    crate://crates.io/html-escape/0.2.13 \
    crate://crates.io/http-client/6.5.3 \
    crate://crates.io/http-types/2.12.0 \
    crate://crates.io/http/0.2.9 \
    crate://crates.io/httparse/1.8.0 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/iana-time-zone-haiku/0.1.1 \
    crate://crates.io/iana-time-zone/0.1.56 \
    crate://crates.io/idna/0.3.0 \
    crate://crates.io/indexmap/1.9.3 \
    crate://crates.io/industrial-io/0.5.2 \
    crate://crates.io/infer/0.2.3 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/io-lifetimes/1.0.10 \
    crate://crates.io/is-terminal/0.4.7 \
    crate://crates.io/itoa/1.0.6 \
    crate://crates.io/js-sys/0.3.62 \
    crate://crates.io/kv-log-macro/1.0.7 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/lexical-core/0.7.6 \
    crate://crates.io/libc/0.2.144 \
    crate://crates.io/libiio-sys/0.3.1 \
    crate://crates.io/libsystemd-sys/0.9.3 \
    crate://crates.io/link-cplusplus/1.0.8 \
    crate://crates.io/linux-raw-sys/0.3.7 \
    crate://crates.io/lock_api/0.4.9 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memmap/0.7.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/memoffset/0.7.1 \
    crate://crates.io/micromath/1.1.1 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/mime_guess/2.0.4 \
    crate://crates.io/miniz_oxide/0.7.1 \
    crate://crates.io/mqtt-protocol/0.11.2 \
    crate://crates.io/nix/0.23.2 \
    crate://crates.io/nix/0.26.2 \
    crate://crates.io/nom/5.1.3 \
    crate://crates.io/num-integer/0.1.45 \
    crate://crates.io/num-traits/0.2.15 \
    crate://crates.io/num_cpus/1.15.0 \
    crate://crates.io/numtoa/0.2.4 \
    crate://crates.io/once_cell/1.17.1 \
    crate://crates.io/opaque-debug/0.3.0 \
    crate://crates.io/ordered-stream/0.2.0 \
    crate://crates.io/parking/2.1.0 \
    crate://crates.io/parking_lot_core/0.9.7 \
    crate://crates.io/percent-encoding/2.2.0 \
    crate://crates.io/pin-project-internal/1.0.12 \
    crate://crates.io/pin-project-lite/0.1.12 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-project/1.0.12 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.27 \
    crate://crates.io/png/0.17.8 \
    crate://crates.io/polling/2.8.0 \
    crate://crates.io/polyval/0.4.5 \
    crate://crates.io/ppv-lite86/0.2.17 \
    crate://crates.io/proc-macro-crate/1.3.1 \
    crate://crates.io/proc-macro-hack/0.5.20+deprecated \
    crate://crates.io/proc-macro2/1.0.56 \
    crate://crates.io/quote/1.0.27 \
    crate://crates.io/radium/0.7.0 \
    crate://crates.io/rand/0.7.3 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.2.2 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.5.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rand_hc/0.2.0 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/redox_syscall/0.3.5 \
    crate://crates.io/regex-syntax/0.7.1 \
    crate://crates.io/regex/1.8.1 \
    crate://crates.io/route-recognizer/0.2.0 \
    crate://crates.io/rustc_version/0.2.3 \
    crate://crates.io/rustix/0.37.19 \
    crate://crates.io/rustversion/1.0.12 \
    crate://crates.io/ryu/1.0.13 \
    crate://crates.io/scopeguard/1.1.0 \
    crate://crates.io/scratch/1.0.5 \
    crate://crates.io/semver-parser/0.7.0 \
    crate://crates.io/semver/0.9.0 \
    crate://crates.io/serde/1.0.162 \
    crate://crates.io/serde_derive/1.0.162 \
    crate://crates.io/serde_fmt/1.0.3 \
    crate://crates.io/serde_json/1.0.96 \
    crate://crates.io/serde_qs/0.8.5 \
    crate://crates.io/serde_repr/0.1.12 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/serde_yaml/0.9.21 \
    crate://crates.io/sha-1/0.10.1 \
    crate://crates.io/sha1/0.10.5 \
    crate://crates.io/sha1/0.6.1 \
    crate://crates.io/sha1_smol/1.0.0 \
    crate://crates.io/sha2/0.9.9 \
    crate://crates.io/signal-hook-registry/1.4.1 \
    crate://crates.io/signal-hook/0.3.15 \
    crate://crates.io/simd-adler32/0.3.5 \
    crate://crates.io/simple-mutex/1.1.5 \
    crate://crates.io/slab/0.4.8 \
    crate://crates.io/smallvec/1.10.0 \
    crate://crates.io/socket2/0.4.9 \
    crate://crates.io/standback/0.2.17 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/stdweb-derive/0.5.3 \
    crate://crates.io/stdweb-internal-macros/0.2.9 \
    crate://crates.io/stdweb-internal-runtime/0.1.5 \
    crate://crates.io/stdweb/0.4.20 \
    crate://crates.io/subtle/2.4.1 \
    crate://crates.io/surf/2.3.2 \
    crate://crates.io/sval/1.0.0-alpha.5 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.15 \
    crate://crates.io/sysfs-class/0.1.3 \
    crate://crates.io/systemd/0.10.0 \
    crate://crates.io/tap/1.0.1 \
    crate://crates.io/tempfile/3.5.0 \
    crate://crates.io/termcolor/1.2.0 \
    crate://crates.io/thiserror-impl/1.0.40 \
    crate://crates.io/thiserror/1.0.40 \
    crate://crates.io/thread-priority/0.13.1 \
    crate://crates.io/tide/0.16.0 \
    crate://crates.io/time-macros-impl/0.1.2 \
    crate://crates.io/time-macros/0.1.1 \
    crate://crates.io/time/0.1.45 \
    crate://crates.io/time/0.2.27 \
    crate://crates.io/tinyvec/1.6.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio/1.28.0 \
    crate://crates.io/toml_datetime/0.6.1 \
    crate://crates.io/toml_edit/0.19.8 \
    crate://crates.io/tracing-attributes/0.1.24 \
    crate://crates.io/tracing-core/0.1.30 \
    crate://crates.io/tracing/0.1.37 \
    crate://crates.io/tungstenite/0.18.0 \
    crate://crates.io/typenum/1.16.0 \
    crate://crates.io/uds_windows/1.0.2 \
    crate://crates.io/unicase/2.6.0 \
    crate://crates.io/unicode-bidi/0.3.13 \
    crate://crates.io/unicode-ident/1.0.8 \
    crate://crates.io/unicode-normalization/0.1.22 \
    crate://crates.io/unicode-width/0.1.10 \
    crate://crates.io/unique-token/0.2.0 \
    crate://crates.io/universal-hash/0.4.1 \
    crate://crates.io/unsafe-libyaml/0.2.8 \
    crate://crates.io/url/2.3.1 \
    crate://crates.io/utf-8/0.7.6 \
    crate://crates.io/utf8-cstr/0.1.6 \
    crate://crates.io/utf8-width/0.1.6 \
    crate://crates.io/value-bag/1.0.0-alpha.9 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/waker-fn/1.1.0 \
    crate://crates.io/wasi/0.10.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.9.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.85 \
    crate://crates.io/wasm-bindgen-futures/0.4.35 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.85 \
    crate://crates.io/wasm-bindgen-macro/0.2.85 \
    crate://crates.io/wasm-bindgen-shared/0.2.85 \
    crate://crates.io/wasm-bindgen/0.2.85 \
    crate://crates.io/web-sys/0.3.62 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.45.0 \
    crate://crates.io/windows-sys/0.48.0 \
    crate://crates.io/windows-targets/0.42.2 \
    crate://crates.io/windows-targets/0.48.0 \
    crate://crates.io/windows/0.48.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.2 \
    crate://crates.io/windows_aarch64_gnullvm/0.48.0 \
    crate://crates.io/windows_aarch64_msvc/0.42.2 \
    crate://crates.io/windows_aarch64_msvc/0.48.0 \
    crate://crates.io/windows_i686_gnu/0.42.2 \
    crate://crates.io/windows_i686_gnu/0.48.0 \
    crate://crates.io/windows_i686_msvc/0.42.2 \
    crate://crates.io/windows_i686_msvc/0.48.0 \
    crate://crates.io/windows_x86_64_gnu/0.42.2 \
    crate://crates.io/windows_x86_64_gnu/0.48.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.2 \
    crate://crates.io/windows_x86_64_gnullvm/0.48.0 \
    crate://crates.io/windows_x86_64_msvc/0.42.2 \
    crate://crates.io/windows_x86_64_msvc/0.48.0 \
    crate://crates.io/winnow/0.4.1 \
    crate://crates.io/wyz/0.5.1 \
    crate://crates.io/xdg-home/1.0.0 \
    crate://crates.io/zbus/3.12.0 \
    crate://crates.io/zbus_macros/3.12.0 \
    crate://crates.io/zbus_names/2.5.0 \
    crate://crates.io/zvariant/3.12.0 \
    crate://crates.io/zvariant_derive/3.12.0 \
    crate://crates.io/zvariant_utils/1.0.0 \
"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

SUMMARY = "tacd"
HOMEPAGE = "https://github.com/linux-automation/tacd"
LICENSE = "GPL-2.0-or-later"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include tacd-${PV}.inc
include tacd.inc
