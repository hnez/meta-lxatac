require recipes-bsp/barebox/barebox.inc

SRC_URI = " \
    git://git.pengutronix.de/git/barebox;protocol=https;branch=master \
    file://defconfig \
    file://env \
"
require files/patches/series.inc

SRCREV = "7f147d2ef6edd49defa0c136f44dfdc3c103569e"
S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "lxatac"

BAREBOX_IMAGES = "*.stm32"

BAREBOX_DTBS_TO_DEPLOY = "arch/arm/dts/*.dtb"

do_deploy:append () {
	for DTB in ${BAREBOX_DTBS_TO_DEPLOY}; do
		if [ -e ${DTB} ]; then
			BAREBOX_DTB_BASENAME=barebox-$(basename ${DTB} .dtb)${BAREBOX_IMAGE_SUFFIX}
			install -m 644 -T ${DTB} ${DEPLOYDIR}/${BAREBOX_DTB_BASENAME}-${DATETIME}.dtb
			ln -sf ${BAREBOX_DTB_BASENAME}-${DATETIME}.dtb ${DEPLOYDIR}/${BAREBOX_DTB_BASENAME}.dtb
		fi
	done
}

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${WORKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${WORKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
