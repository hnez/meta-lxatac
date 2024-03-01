# umpf-base: v6.8-rc1
# umpf-name: 6.8/customers/lxa/lxatac
# umpf-version: 6.8/customers/lxa/lxatac/20240301-1
# umpf-topic: v6.8/topic/reproducible-build
# umpf-hashinfo: aeac9bbaa9085d2c80f294d9ebfd8d9fd78212bf
# umpf-topic-range: 6613476e225e090cc9aad49be7fa504e290dd33d..f99b7ea1a2e3ee4f7053315b3a72f5a5937bea69
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  file://patches/0002-vt-conmakehash-improve-reproducibility.patch \
  file://patches/0003-lib-build_OID_registry-fix-reproducibility-issues.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: ec50b8697a4d79c2ab7e570f4e657f97b6c10516
# umpf-topic-range: f99b7ea1a2e3ee4f7053315b3a72f5a5937bea69..7e3e94deeb54973397a8ce7deed0c0b694aa576b
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0103-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0104-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  "
# umpf-release: 6.8/customers/lxa/lxatac/20240301-1
# umpf-topic-range: 7e3e94deeb54973397a8ce7deed0c0b694aa576b..9bb1a91e9da735dee78370926cdec65d61cbbad3
SRC_URI += "\
  file://patches/0201-Release-6.8-customers-lxa-lxatac-20240301-1.patch \
  "
# umpf-end
