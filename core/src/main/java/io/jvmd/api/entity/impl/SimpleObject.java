package io.jvmd.api.entity.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import io.jvmd.api.entity.Object;
import io.jvmd.api.world.impl.SimpleWorld;


public class SimpleObject implements Object {

    private final String name;
    private final Model model;
    private final ModelBatch modelBatch;
    private ModelInstance instance;
    private final AnimationController animationController;

    private Camera camera;
    private Vector3 position = new Vector3();
    private Quaternion rotation = new Quaternion();

    private SimpleWorld world;


    public SimpleObject(String name, Model model, Camera perspectiveCamera) {
        this.name = name;
        this.model = model;
        this.instance = new ModelInstance(model);
        this.animationController = new AnimationController(getInstance());
        this.camera = perspectiveCamera;
        modelBatch = new ModelBatch();
    }

    public SimpleObject(String worldPlane, Model model) {
        this(worldPlane, model, null);
    }


    @Override
    public void update() {
        instance.transform.setToTranslation(position.x, position.y, position.z);
        instance.transform.rotate(rotation);
    }

    @Override
    public void setPosition(Vector3 position) {
        this.position = position;
    }

    @Override
    public void setRotation(Quaternion rotation) {
        this.rotation = rotation;
    }

    @Override
    public void render(Environment environment) {
        modelBatch.begin(camera);

        modelBatch.render(instance, environment);

        modelBatch.end();
    }

    @Override
    public void setModel(ModelInstance instance) {
        this.instance = instance;
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        model.dispose();
    }

    public ModelInstance getInstance() {
        return instance;
    }


    public String getName() {
        return name;
    }

    public Model getModel() {
        return model;
    }

    public ModelBatch getModelBatch() {
        return modelBatch;
    }

    public Camera getCamera() {
        return camera;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Quaternion getRotation() {
        return rotation;
    }

    public AnimationController getAnimationController() {
        return animationController;
    }

    public SimpleWorld getWorld() {
        return world;
    }

    public void setWorld(SimpleWorld world) {
        this.world = world;
    }
}
