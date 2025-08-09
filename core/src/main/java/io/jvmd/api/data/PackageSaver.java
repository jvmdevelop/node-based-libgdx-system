package io.jvmd.api.data;

import io.jvmd.api.preferences.Config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public final class PackageSaver {

    public void save(PackageNode node , ECategory category) throws IOException {

        Objects.requireNonNull(node, "object is null");

        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(Config.getPrefix() + "/" +category.getLocation() + "/" + node.getNodeName())));

        oos.writeObject(node);
        oos.flush();
        oos.close();
    }

}
