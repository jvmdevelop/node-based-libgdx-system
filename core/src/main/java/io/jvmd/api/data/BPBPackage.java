package io.jvmd.api.data;

import java.io.IOException;

public interface BPBPackage<T> {

    String getLocation();
    PackageSaver getSaver();
    Object load(String link) throws IOException, ClassNotFoundException;
    void save(PackageNode node) throws IOException;

}
