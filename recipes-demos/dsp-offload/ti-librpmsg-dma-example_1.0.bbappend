SUMMARY = "DSP Offload & TVM based EdgeAI Examples using RPMsg DMA library"

inherit systemd

# Append the systemd directory flag to CMake options
EXTRA_OECMAKE:append = " -DSYSTEMD_SYSTEM_UNITDIR=${systemd_system_unitdir}"

# Add required dependencies for edge-ai application
DEPENDS:append = " ti-tidl-osrt json-c pkgconfig-native"

EXTRA_OECMAKE:append = " \
    -DTVM_ROOT=${RECIPE_SYSROOT}${includedir}/tvm/tvm \
    -DTVM_RUNTIME_LIB=${RECIPE_SYSROOT}${libdir}/libtvm_runtime.so \
"

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE:${PN} = " \
    tvm-model-preload.service \
    tvm-model-daemon.service \
"

# Install binaries, JSON configs, input files and class labels
FILES:${PN}:append = " \
    ${bindir}/rpmsg_inference_example \
    ${bindir}/tvm_model_daemon \
    ${datadir}/tvm_inference/json/ \
    ${datadir}/tvm_inference/input/ \
    ${datadir}/tvm_inference/labels/ \
    ${libdir}/libti_rpmsg_dma.so* \
    ${systemd_system_unitdir}/tvm-model-daemon.service \
    ${systemd_system_unitdir}/tvm-model-preload.service \
"

FILES:${PN}-dev:append = " ${includedir}/ti_rpmsg_dma/*.h"
