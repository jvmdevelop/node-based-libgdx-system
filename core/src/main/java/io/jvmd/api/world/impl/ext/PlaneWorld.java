package io.jvmd.api.world.impl.ext;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import io.jvmd.api.entity.impl.SimpleObject;
import io.jvmd.api.world.impl.SimpleWorld;

public class PlaneWorld extends SimpleWorld {


    public PlaneWorld(Environment environment, float width, float height, Camera camera) {
        super(environment, camera);
        ModelBuilder modelBuilder = new ModelBuilder();
        Model model = modelBuilder.createBox(width, height, 0.1f , new Material(ColorAttribute.createDiffuse(Color.WHITE)),
            VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

        this.setCamera(camera);

        SimpleObject object = new SimpleObject("world_plane",model, camera);

        // TODO Quaternion use

        Quaternion quaternion = new Quaternion();
//        Quaternion quaternion = new Quaternion(Vector3.Y, 180);

        quaternion.setEulerAngles(0 , 90  ,0); // y x z

        object.setRotation(quaternion);

        object.update();

        object.setWorld(this);

        add(object);
    }


}
