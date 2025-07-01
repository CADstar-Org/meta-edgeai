DISTROOVERRIDES:append = ":adas"

VDK_INCLUDES = ""
VDK_INCLUDES:tda54-vdk = "conf/distro/include/branding-vdk.inc"
require ${VDK_INCLUDES}
