package io.jvmd.api.actors.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.actors.ShapedActor;
import io.jvmd.api.data.PackageNode;
import io.jvmd.api.world.BPBWorld;

public class SimpleActor extends ActorImpl implements ShapedActor {


    private Vector2 proportion;
    private Body body;


    public SimpleActor(BodyDef.BodyType bodyType, Texture texture , Vector2 position, Vector2 proportion, BPBWorld world) {
        super(position, texture);
        this.proportion = proportion;
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        bodyDef.position.set(calculatePosition());
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

    private Vector2 calculatePosition() {
        Texture texture = getTexture();
        int x = (int) (getPosition().x + ((float) texture.getHeight() / 2));
        int y = (int) (getPosition().y + ((float) texture.getWidth() / 2));
        return new Vector2(x, y);
    }


    @Override
    public void render(Batch batch) {
        if (this.batch == null) {
            this.batch = batch;
        }
        body.setTransform(getPosition().x, getPosition().y , 0);
        batch.setProjectionMatrix(getCamera().combined);
        batch.begin();

        batch.draw(getTexture(), body.getPosition().x, body.getPosition().y);

        batch.end();
    }

    @Override
    public void setProportions(Vector2 proportions) {
        this.proportion = proportions;
    }

    @Override
    public PolygonShape getShape() {
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(proportion.x, proportion.y);
        return shape;
    }

    public Body getBody() {
        return body;
    }

    public Vector2 getProportion() {
        return proportion;
    }
}
