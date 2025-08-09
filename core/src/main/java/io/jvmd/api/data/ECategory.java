package io.jvmd.api.data;

public enum ECategory implements BPBPackage {

    WORLD {
        @Override
        public String getLocation() {
            return "world";
        }
    },
    PREFERENCES {
        @Override
        public String getLocation() {
            return "preferences";
        }
    };


    private final PackageSaver saver = new PackageSaver();

    @Override
    public PackageSaver getSaver() {
        return saver;
    }

}
