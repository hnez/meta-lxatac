# umpf-base: v6.3-rc4
# umpf-name: 6.3/customers/lxa/lxatac
# umpf-version: 6.3/customers/lxa/lxatac/20230330-1
# umpf-topic: v6.3/customers/lxa/lxatac
# umpf-hashinfo: e0c17a177b91dcc3f4e9555521b158f32e921c05
# umpf-topic-range: 197b6b60ae7bc51dd0814953c562833143b292aa..af639f005be3bbac9d35af0b03e0a8f961701cbc
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-Add-coprocessor-detach-mbox-on-stm32mp.patch \
  file://patches/0002-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0004-ARM-dts-stm32-lxa-tac-add-Gen-2-support.patch \
  "
# umpf-topic: v6.3/topic/stm32mp1-spi
# umpf-hashinfo: 1e138a9c607b95c42695d1c1dd3477ae45020176
# umpf-topic-range: af639f005be3bbac9d35af0b03e0a8f961701cbc..9ec271baf16d2814aa51282d5f028896cb604565
SRC_URI += "\
  file://patches/0101-spi-core-add-spi_split_transfers_maxwords.patch \
  file://patches/0102-spi-stm32-split-large-transfers-based-on-word-size-i.patch \
  "
# umpf-topic: v6.3/topic/pwm-stm32
# umpf-hashinfo: 2c6f563a2f773e3af9a15f22dcce5a550d182a57
# umpf-topic-range: 9ec271baf16d2814aa51282d5f028896cb604565..4016056924b2a0866362fa703468a40d817d941b
SRC_URI += "\
  file://patches/0201-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.3/topic/pwm-backlight
# umpf-hashinfo: 70e6aacfc3b309e4838d674d5fd7c815c36a6ee9
# umpf-topic-range: 4016056924b2a0866362fa703468a40d817d941b..852d7a41e6633a2d99016e692380a291c2278659
SRC_URI += "\
  file://patches/0301-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-release: 6.3/customers/lxa/lxatac/20230330-1
# umpf-topic-range: 852d7a41e6633a2d99016e692380a291c2278659..6a9a0199b0eda55bb31883f2d931b56f5910a133
SRC_URI += "\
  file://patches/0401-Release-6.3-customers-lxa-lxatac-20230330-1.patch \
  "
# umpf-end
