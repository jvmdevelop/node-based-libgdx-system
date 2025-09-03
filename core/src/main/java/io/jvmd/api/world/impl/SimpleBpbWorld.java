package io.jvmd.api.world.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.data.PackageNode;
import io.jvmd.api.world.BPBWorld;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimpleBpbWorld extends PackageNode implements BPBWorld  {

    private World world;
    private Map<String , Actor> actors;
    private SpriteBatch userBatch;
    private ObjectIndexer objectIndexer;
    private Camera camera;

    @Override
    public Actor getActor(String name_id) {
        return actors.get(name_id);
    }

    public void addActors(List<Actor> actorsList) {
        actorsList.forEach((actor)->{
            actors.put(Actor.prefix + objectIndexer.giveIndex(actor),actor);
        });
    }

    public int getIndex(Actor actor) {
        return objectIndexer.getIndex(actor);
    }

    @Override
    public void update(Actor actor) {
            actors.put(actor.prefix + getIndex(actor) , actor);
    }

    @Override
    public void setup() {
        world = new World(new Vector2(0, 0), true);
        actors = new HashMap<>();
        objectIndexer = new ObjectIndexer();
    }

    @Override
    public void render() {
        //todo render only what see a camera
        Box2DDebugRenderer renderer = new Box2DDebugRenderer();
        renderer.render(world, camera.combined);
        actors.values().forEach((actor) -> {
            actor.setWorld(this);
            actor.setCamera(camera);
            actor.render(userBatch);
        });
        world.step(1/60f, 6, 2);
        camera.update();
    }

    @Override
    public void addActor(Actor actor) {
        int i = objectIndexer.giveIndex(actor);
        actors.put(actor.prefix + i, actor);
    }

    @Override
    public void removeActor(Actor actor) {
        int index = objectIndexer.getIndex(actor);

        actors.remove(actor.prefix + index);
    }

    @Override
    public void setCamera(Camera camera) {
        this.camera=  camera;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public void setBatch(Batch batch) {
        this.userBatch = (SpriteBatch) batch;
    }


}
