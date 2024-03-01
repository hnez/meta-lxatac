inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

PV = "6.8-rc1"

SRC_URI = "https://git.kernel.org/torvalds/t/linux-${PV}.tar.gz \
           file://defconfig \
           "

SRC_URI[sha256sum] = "327c0c2dcbe348ab9902dc30511f5cfb239cfff8a8d285b29779c4b5bd7c8e42"

require files/patches/series.inc

S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_MACHINE = "lxatac"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${S}/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${S}/firmware/
}

addtask copy_fw after do_configure before do_compile
