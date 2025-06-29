package io.jvmd.api.actors.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.world.BPBWorld;

public class SimpleActor implements Actor {

    private BPBWorld world;
    private OrthographicCamera camera;
    private Vector2 position;
    private Texture texture;
    private Vector2 proportion;
    private Body body;

    public Batch batch;

    public SimpleActor(BodyDef.BodyType bodyType, Vector2 position, Vector2 proportion, BPBWorld world) {
        this.proportion = proportion;
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        this.position = position;
        bodyDef.position.set(this.position);
        body  = world.getWorld().createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = getShape();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 1.0f;
        fixtureDef.restitution = 1.0f;

        body.createFixture(fixtureDef);
        shape.dispose();
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
    public PolygonShape getShape() {
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(proportion.x, proportion.y);
        return shape;
    }

    @Override
    public void setProportions(Vector2 proportions) {
        this.proportion = proportions;
    }

    @Override
    public void render(Batch batch) {
        if (this.batch == null) {
            this.batch = batch;
        }
        body.setTransform(position.x, position.y, 0);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(texture, position.x, position.y);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
