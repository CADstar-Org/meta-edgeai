PR:append = "_edgeai_1"

# Remove GPU driver sources for tda54
GRAPHICS_RDEPENDS:remove:tda54 = "${@bb.utils.contains('MACHINE_FEATURES','gpu','${PREFERRED_PROVIDER_virtual/gpudriver}-src','',d)}"
