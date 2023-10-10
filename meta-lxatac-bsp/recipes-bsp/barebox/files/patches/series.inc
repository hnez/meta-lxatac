# umpf-base: master
# umpf-name: 2023.10.0/customers/lxa/tac
# umpf-version: 2023.10.0/customers/lxa/tac/20231009-1
# umpf-topic: v2023.10.0/topic/tlv
# umpf-hashinfo: c084412d75055e151079408b2ebbb4184c0d5985
# umpf-topic-range: 7f147d2ef6edd49defa0c136f44dfdc3c103569e..06990d7b3dc97d3ca5ecdba3066737ec18ab3144
SRC_URI += "\
  file://patches/0001-scripts-implement-slurp-a-read_file-with-fd-as-argum.patch \
  file://patches/0002-of_path-support-phandles-in-of_find_path.patch \
  file://patches/0003-Makefile-add-common-boards-include-to-include-search.patch \
  file://patches/0004-net-add-ethaddr-sequence-handling.patch \
  file://patches/0005-common-add-global.serial_number-with-device-tree-fix.patch \
  file://patches/0006-common-add-optional-systemd.hostname-generation.patch \
  file://patches/0007-net-factor-out-eth_of_get_fixup_node.patch \
  file://patches/0008-net-export-list-of-registered-ethernet-addresses.patch \
  file://patches/0009-net-implement-ethaddr_string_cmp.patch \
  file://patches/0010-common-add-barebox-TLV-support.patch \
  file://patches/0011-commands-add-TLV-debugging-command.patch \
  file://patches/0012-scripts-add-bareboxtlv-host-target-tool.patch \
  "
# umpf-topic: v2023.10.0/customers/lxa/tac
# umpf-hashinfo: f1e6363550f1c78ed8ea2368d0fa5bef82b6e9e5
# umpf-topic-range: 06990d7b3dc97d3ca5ecdba3066737ec18ab3144..117fdf763e7009ddddda39b83f55c053e20719cf
SRC_URI += "\
  file://patches/0101-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0102-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  "
# umpf-release: 2023.10.0/customers/lxa/tac/20231009-1
# umpf-topic-range: 117fdf763e7009ddddda39b83f55c053e20719cf..d061fc885324a5d615e80103fbcef295ca0fc32d
SRC_URI += "\
  file://patches/0201-Release-2023.10.0-customers-lxa-tac-20231009-1.patch \
  "
# umpf-end
