#!/bin/bash

set -euo pipefail

SRC_CHOSEN="/sys/firmware/devicetree/base/chosen"
SRC_BASEBOARD_BASE="${SRC_CHOSEN}/baseboard-factory-data"

DST_ENVS_BASE="/run/lxatac-factory-data"
DST_LINK_FILE_BASE="/run/systemd/network/"

mkdir -p "${DST_ENVS_BASE}"
mkdir -p "${DST_LINK_FILE_BASE}"

# Set the static hostname if it is not set yet
# (The transient hostname is passed via systemd.hostname= commandline)
# --------------------------------------------------------------------

if [[ ! -e /etc/hostname ]]
then
    hostname="$(hostnamectl --transient hostname)"
    hostnamectl --static hostname "${hostname}"
fi

# Read Factory Data passed to us by barebox via the devicetree
# ------------------------------------------------------------

# Strip trailing "\0" Byte
SERIAL=$(tr -d '\000' < "${SRC_BASEBOARD_BASE}/serial-number")

mapfile -t MAC_ADDRESSES < <(
    for ADDR_FILE in "${SRC_BASEBOARD_BASE}/ethernet-address/address-"*
    do
        tr -d '\000' < "${ADDR_FILE}" || true
        echo
    done | sort || true
)

MAC_BRIDGE=${MAC_ADDRESSES[0]}
MAC_USB_DEV=${MAC_ADDRESSES[1]}
MAC_USB_HOST=${MAC_ADDRESSES[2]}

# Save a script to be sourced by the tac-gadget-* helpers
# -------------------------------------------------------

cat > "${DST_ENVS_BASE}/usb-gadget.sh" << EOF
#!/bin/bash

# Generated by $0

SERIAL="${SERIAL}"
HOST_MAC="${MAC_USB_HOST}"
DEV_MAC="${MAC_USB_DEV}"
EOF

chmod +x "${DST_ENVS_BASE}/usb-gadget.sh"

# Set MAC address for the tac-bridge interface
# --------------------------------------------

cat > "${DST_LINK_FILE_BASE}/10-tac-bridge.link" << EOF
# Generated by $0

[Match]
OriginalName=tac-bridge

[Link]
MACAddress=${MAC_BRIDGE}
MACAddressPolicy=none
EOF

