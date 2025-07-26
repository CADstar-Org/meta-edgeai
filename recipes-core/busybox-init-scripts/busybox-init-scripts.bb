DESCRIPTION = "Busybox init scripts"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PV = "1.0"

SRC_URI = "file://S11modules file://S01mount-dev-shm.sh"

INITSCRIPT_NAME = "S11modules"
INITSCRIPT_PARAMS = "start 5 S ."

S = "${WORKDIR}"

inherit allarch update-rc.d

do_install () {
	install -d ${D}${sysconfdir}/rcS.d
	install -m 0755 ${WORKDIR}/S11modules ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${WORKDIR}/S01mount-dev-shm.sh ${D}${sysconfdir}/rcS.d/
}

do_compile[noexec] = "1"
do_configure[noexec] = "1"
