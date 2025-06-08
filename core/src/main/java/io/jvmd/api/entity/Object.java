package io.jvmd.api.entity;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public interface Object {

    void update();
    void render(Environment environment);
    void setModel(ModelInstance instance);
    void setPosition(Vector3 position);
    void setRotation(Quaternion rotation);
    void dispose();
}
