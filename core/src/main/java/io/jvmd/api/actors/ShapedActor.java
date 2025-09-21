package io.jvmd.api.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public interface ShapedActor extends Actor {

    void setProportions(Vector2 proportions);
    PolygonShape getShape();

}
