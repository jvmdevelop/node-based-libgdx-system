package io.jvmd.api.data;

import java.io.IOException;

public interface BPBPackage {

    String getLocation();
    PackageSaver getSaver();
    void save(PackageNode node) throws IOException;

}
