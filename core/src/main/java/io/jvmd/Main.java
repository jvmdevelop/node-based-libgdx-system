package io.jvmd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import io.jvmd.api.entity.impl.Entity;
import io.jvmd.api.entity.impl.SimpleObject;
import io.jvmd.api.world.impl.ext.PlaneWorld;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {

    private Camera cam;
    private Environment environment;
    private CameraInputController camController;
    private PlaneWorld planeWorld;
    private SimpleObject simpleObject;
    private Vector3 spawnPos = new Vector3(0,20,0);
    private Entity entity;

    @Override
    public void create() {


        cam = new PerspectiveCamera(90,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(5f, 5f, 5f);
        cam.lookAt(spawnPos);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        planeWorld = new PlaneWorld(environment, 100f, 100f, cam);

        ModelBuilder modelBuilder = new ModelBuilder();
        Model model = modelBuilder.createCone(10f, 10f, 10f, 10, new Material(ColorAttribute.createDiffuse(Color.RED)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

        simpleObject = new SimpleObject("name", model, cam);
        simpleObject.setWorld(planeWorld);
        simpleObject.setPosition(spawnPos);

        entity = new Entity("Dan", model, cam, 100) {
            @Override
            public void walk() {

            }

            @Override
            public void jump() {

            }
        };
        entity.setWorld(planeWorld);
        entity.setPosition(spawnPos);

        planeWorld.add(entity);
        planeWorld.add(simpleObject);


        camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);
    }

    @Override
    public void render() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        camController.update();
        simpleObject.update();

        planeWorld.render();

        entity.update();

    }

    @Override
    public void dispose() {
        simpleObject.dispose();
    }
}
