package io.jvmd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.jvmd.api.actors.impl.AnimatedActor;
import io.jvmd.api.actors.impl.entity.Entity;
import io.jvmd.api.actors.impl.entity.EntityType;
import io.jvmd.api.world.BPBWorld;
import io.jvmd.api.world.impl.SimpleBpbWorld;
import io.jvmd.api.input.BPBInputProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {

    private BPBWorld world;
    private SpriteBatch batch;
    private AnimatedActor animatedActor;
    private Entity player;

    @Override
    public void create() {
        world = new SimpleBpbWorld();
        world.setup();
        batch = new SpriteBatch();
        world.setBatch(batch);
        OrthographicCamera camera = new OrthographicCamera();
        camera.position.setZero();
        camera.setToOrtho(false, 600, 315);
        world.setCamera(camera);

        BPBInputProcessor processor = new BPBInputProcessor();
        Gdx.input.setInputProcessor(processor);

        Map<String, String> paths = new HashMap<String, String>() {
            {
                put("rotated", "player_rotate.png");
            }
        };

        animatedActor = new AnimatedActor(BodyDef.BodyType.StaticBody,
            new Vector2(100, 100), new Vector2(5, 5), world, paths, 8, 1, 0.1f);

        animatedActor.setTexture(new Texture("player.png"));
        animatedActor.setWorld(world);
        animatedActor.setCamera(camera);

        player = new Entity() {
            {
                getType().setInputProcessor(processor);
            }

            @Override
            public String getName() {
                return "jvmd";
            }

            @Override
            public EntityType getType() {
                return EntityType.PLAYER;
            }
        };

        player.setBody(animatedActor);
        world.addActor(player.getBody());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.render();

//        player.getBody().playAnimation("rotated", true , false , false);

        player.move();

        System.out.println(animatedActor.getPosition().x + " " + animatedActor.getPosition().y);
    }

    @Override
    public void dispose() {

    }
}
