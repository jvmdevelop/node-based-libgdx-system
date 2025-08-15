package io.jvmd.api.world.save;

import io.jvmd.api.data.ECategory;
import io.jvmd.api.world.BPBWorld;
import io.jvmd.api.world.impl.SimpleBpbWorld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class WorldManager {

    private final List<String> worldsLinks = new ArrayList<>();


    public static class WorldSaver {

        public static void save(List<SimpleBpbWorld> worlds) {
            worlds.forEach((world) -> {
                try {
                    ECategory.WORLD.save(world);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }

    public static class WorldLoader {

        public static List<String> load() {
            ArrayList<String> worldLinks = new ArrayList<>();

            return worldLinks;
        }

    }


}
