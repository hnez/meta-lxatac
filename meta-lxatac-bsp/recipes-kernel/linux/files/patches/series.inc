# umpf-base: v6.3-rc4
# umpf-name: 6.3/customers/lxa/lxatac
# umpf-version: 6.3/customers/lxa/lxatac/20230405-2
# umpf-topic: v6.3/customers/lxa/lxatac
# umpf-hashinfo: c6cde315a49bc79c3d12ac4a2670eaad6f803171
# umpf-topic-range: 197b6b60ae7bc51dd0814953c562833143b292aa..3aae8ad1caf19b594a26178486a3d6ff83753707
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-Add-coprocessor-detach-mbox-on-stm32mp.patch \
  file://patches/0002-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0004-ARM-dts-stm32-lxa-tac-add-Gen-2-support.patch \
  file://patches/0005-leds-gpio-always-set-up-brightness_set_blocking-op.patch \
  "
# umpf-topic: v6.3/topic/stm32mp1-spi
# umpf-hashinfo: 1e138a9c607b95c42695d1c1dd3477ae45020176
# umpf-topic-range: 3aae8ad1caf19b594a26178486a3d6ff83753707..9762ddc7333c91b841426080c3c7b9bc419b40d0
SRC_URI += "\
  file://patches/0101-spi-core-add-spi_split_transfers_maxwords.patch \
  file://patches/0102-spi-stm32-split-large-transfers-based-on-word-size-i.patch \
  "
# umpf-topic: v6.3/topic/pwm-stm32
# umpf-hashinfo: 2c6f563a2f773e3af9a15f22dcce5a550d182a57
# umpf-topic-range: 9762ddc7333c91b841426080c3c7b9bc419b40d0..1994db7d21ed19fe4826488b4d5b15ff1970c1f9
SRC_URI += "\
  file://patches/0201-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.3/topic/pwm-backlight
# umpf-hashinfo: 70e6aacfc3b309e4838d674d5fd7c815c36a6ee9
# umpf-topic-range: 1994db7d21ed19fe4826488b4d5b15ff1970c1f9..aa1cf38185b59dabf197992f1a2fa2dfccd8fdc4
SRC_URI += "\
  file://patches/0301-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-release: 6.3/customers/lxa/lxatac/20230405-2
# umpf-topic-range: aa1cf38185b59dabf197992f1a2fa2dfccd8fdc4..ee16d880a240e54e4fad1befb9ca4edde784a5bc
SRC_URI += "\
  file://patches/0401-Release-6.3-customers-lxa-lxatac-20230405-2.patch \
  "
# umpf-end
