package io.jvmd.api.actors;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import io.jvmd.api.world.BPBWorld;

public interface Actor {

    String prefix = "actor_";

    BPBWorld getWorld();
    void setWorld(BPBWorld world);

    OrthographicCamera getCamera();
    void setCamera(Camera camera);

    void setPosition(Vector2 position);
    Vector2 getPosition();

    Texture getTexture();
    void setTexture(Texture texture);

    PolygonShape getShape();

    void setProportions(Vector2 proportions);

    void render(Batch batch);

    void dispose();



}
