package io.jvmd.api.entity;

import com.badlogic.gdx.utils.ObjectMap;
import io.jvmd.api.entity.impl.Entity;
import io.jvmd.api.entity.impl.SimpleObject;

public class ObjectPool<T extends SimpleObject> {

    private final ObjectMap<String, T> objects = new ObjectMap<>();

    public void add(T entity) {
        objects.put(entity.getName(), entity);
    }

    public void remove(String name) {
        objects.remove(name);
    }

    public ObjectMap<String, T> getObjects() {
        return objects;
    }


}
