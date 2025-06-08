package io.jvmd.api.world;

import io.jvmd.api.entity.impl.SimpleObject;

public interface World {

    void render();
    void add(SimpleObject instance);
    void remove(String key);


}

