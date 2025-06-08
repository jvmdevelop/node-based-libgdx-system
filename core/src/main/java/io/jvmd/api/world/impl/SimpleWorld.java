package io.jvmd.api.world.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Environment;
import io.jvmd.api.entity.ObjectPool;
import io.jvmd.api.entity.impl.Entity;
import io.jvmd.api.entity.impl.SimpleObject;
import io.jvmd.api.world.World;

public  class SimpleWorld implements World {

    private final Environment environment;

    private final ObjectPool<SimpleObject> objectPool = new ObjectPool<>();
    private final ObjectPool<Entity> entityPool = new ObjectPool<>();
    private Camera camera;

    public SimpleWorld(Environment environment, Camera camera) {
        this.environment = environment;
        this.camera = camera;
    }

    @Override
    public void render() {
        objectPool.getObjects().forEach(instance -> {
            instance.value.render(environment);
        });
    }

    @Override
    public void add(SimpleObject instance) {
        if (instance instanceof Entity) entityPool.add((Entity) instance);
        if (instance != null) objectPool.add(instance);
//        instance.render(environment);
    }


    @Override
    public void remove(String key) {
       objectPool.remove(key);
    }


    public ObjectPool<SimpleObject> getObjectPool() {
        return objectPool;
    }

    public ObjectPool<Entity> getEntityPool() {
        return entityPool;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
