# umpf-base: v6.3-rc1
# umpf-name: 6.3/customers/lxa/lxatac
# umpf-version: 6.3/customers/lxa/lxatac/20230308-1
# umpf-topic: v6.3/customers/lxa/lxatac
# umpf-hashinfo: 630f91f7ef83f75192363f04cdad4fa05c72026d
# umpf-topic-range: fe15c26ee26efa11741a7b632e9f23b01aca4cc6..0c367a652a673c7d8e2d8bfbf516e91cbde5b94f
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-Add-coprocessor-detach-mbox-on-stm32mp.patch \
  file://patches/0002-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0004-ARM-dts-stm32-lxa-tac-add-Gen-2-support.patch \
  "
# umpf-topic: v6.3/topic/stm32mp1-spi
# umpf-hashinfo: 39edf8671e79446eba2aaeb00a6ea3383222193d
# umpf-topic-range: 0c367a652a673c7d8e2d8bfbf516e91cbde5b94f..6722d2efdfc6109bbc0f9e5a33875922788e40f1
SRC_URI += "\
  file://patches/0101-spi-core-add-spi_split_transfers_maxwords.patch \
  file://patches/0102-spi-stm32-split-large-transfers-based-on-word-size-i.patch \
  "
# umpf-release: 6.3/customers/lxa/lxatac/20230308-1
# umpf-topic-range: 6722d2efdfc6109bbc0f9e5a33875922788e40f1..8a2022303b4b0cebf2d96e351fc6b96b6c3e0b38
SRC_URI += "\
  file://patches/0201-Release-6.3-customers-lxa-lxatac-20230308-1.patch \
  "
# umpf-end
