package io.jvmd.api.data;

import io.jvmd.api.preferences.Config;

import java.io.*;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @Override
    public PackageNode load(String link) {
        try (final ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(link)))) {

            Object obj = ois.readObject();

            if (obj instanceof PackageNode) {
                return (PackageNode) obj;
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<String> loads() {
        StringBuilder builder = new StringBuilder();
        builder.append(Config.getPrefix());
        builder.append(File.separator).append(getLocation()).append(File.separator);

        List<File> files = new ArrayList<>();
        files.addAll(Arrays.asList(Objects.requireNonNull(Paths.get(builder.toString()).toFile().listFiles())));
        List<String> worldLinks = new ArrayList<>();
        files.forEach((file) -> {
            worldLinks.add(file.getAbsolutePath());
        });

        return worldLinks;
    }


    private final PackageSaver saver = new PackageSaver();

    @Override
    public void save(PackageNode node) throws IOException {
        getSaver().save(node, this);
    }

    // todo make package load

    @Override
    public PackageSaver getSaver() {
        return saver;
    }

}
