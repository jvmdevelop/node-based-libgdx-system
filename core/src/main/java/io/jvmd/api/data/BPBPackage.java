package io.jvmd.api.data;

import java.io.IOException;
import java.util.List;

public interface BPBPackage<T> {

    String getLocation();
    PackageSaver getSaver();
    List<String> loads() throws IOException, ClassNotFoundException;
    PackageNode load(String link) throws IOException, ClassNotFoundException;
    void save(PackageNode node) throws IOException;

}
