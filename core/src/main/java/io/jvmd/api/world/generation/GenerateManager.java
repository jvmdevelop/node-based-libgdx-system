package io.jvmd.api.world.generation;

import io.jvmd.api.world.generation.impl.MatrixGenerator;

import java.util.HashMap;
import java.util.Map;

public final class GenerateManager {

    private final static Map<Integer, Generator> generators = new HashMap<Integer, Generator>() {
        {
            put(0, new MatrixGenerator());
        }
    };

    public Generator getGenerator(int key) {
       return generators.getOrDefault(key , generators.get(0));
    }

}
