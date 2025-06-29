package io.jvmd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.jvmd.api.actors.impl.AnimatedActor;
import io.jvmd.api.actors.impl.SimpleActor;
import io.jvmd.api.world.BPBWorld;
import io.jvmd.api.world.impl.SimpleBpbWorld;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {

    private BPBWorld world;
    private SpriteBatch batch;
    private Texture texture;

    @Override
    public void create() {
        texture = new Texture("developer.png");

        world = new SimpleBpbWorld();
        world.setup();
        batch = new SpriteBatch();
        world.setBatch(batch);
        OrthographicCamera camera = new OrthographicCamera();
        camera.position.setZero();
        camera.setToOrtho(false, 600 , 315);
        world.setCamera(camera);
        SimpleActor actor_1 = new SimpleActor(BodyDef.BodyType.StaticBody, new Vector2(0, 0), new Vector2(5, 5), world);
        actor_1.setTexture(texture);
        actor_1.setWorld(world);

        Map<String  , String> paths = Map.of("rotated" , "");

        AnimatedActor animatedActor = new AnimatedActor(BodyDef.BodyType.StaticBody ,
            new Vector2(4 , 5) , new Vector2(3 ,3 ) , world ,   , 7 , 1   , 0.025);

        world.addActor(actor_1);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.render();
    }

    @Override
    public void dispose() {

    }
}
