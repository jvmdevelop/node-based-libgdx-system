package io.jvmd.api.world.save;

import io.jvmd.api.world.BPBWorld;

import java.util.ArrayList;
import java.util.List;

public final class WorldManager {

    private final List<String> worldsLinks = new ArrayList<>();


    protected static class WorldSaver {

        public static void save(List<BPBWorld> worlds) {

        }

    }

    protected static class WorldLoader {

        public static List<String> load() {
            ArrayList<String> worldLinks = new ArrayList<>();


            return worldLinks;
        }

    }


}
