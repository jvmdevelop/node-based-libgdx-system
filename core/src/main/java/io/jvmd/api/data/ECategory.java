package io.jvmd.api.data;

import java.io.IOException;

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
    },
    ACTOR {
        @Override
        public String getLocation() {
            return "actor";
        }
    };




    private final PackageSaver saver = new PackageSaver();

    @Override
    public void save(PackageNode node) throws IOException {
        getSaver().save(node, this);
    }

    @Override
    public PackageSaver getSaver() {
        return saver;
    }

}
