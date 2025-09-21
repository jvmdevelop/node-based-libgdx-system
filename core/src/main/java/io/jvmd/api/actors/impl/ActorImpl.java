package io.jvmd.api.actors.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.data.PackageNode;
import io.jvmd.api.world.BPBWorld;

public class ActorImpl extends PackageNode implements Actor   {

    private BPBWorld world;
    private OrthographicCamera camera;
    private Vector2 position;
    private Texture texture;
    private Vector2 velocity = new Vector2();
    protected Batch batch;


    public ActorImpl(Vector2 position, Texture texture) {
        this.position = position;
        this.texture = texture;
    }

    @Override
    public BPBWorld getWorld() {
        return world;
    }

    @Override
    public void setWorld(BPBWorld world) {
        this.world = world;
    }

    @Override
    public OrthographicCamera getCamera() {
        return camera;
    }

    @Override
    public void setCamera(Camera camera) {
        this.camera = ( OrthographicCamera) camera;
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void render(Batch batch) {
        if (this.batch == null) {
            this.batch = batch;
        }
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        batch.draw(texture, getPosition().x, getPosition().y);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public Vector2 getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
