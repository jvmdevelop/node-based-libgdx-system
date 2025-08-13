package io.jvmd.api.world.generation;

import java.util.HashMap;
import java.util.Map;

public final class GenerateManager {

    private final static Map<Integer, Generator> generators = new HashMap<Integer, Generator>() {
        {

        }
    };

    public Generator getGenerator(int key) {
       return generators.get(key);
    }

}
