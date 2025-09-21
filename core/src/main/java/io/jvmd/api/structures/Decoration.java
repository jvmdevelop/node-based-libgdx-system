package io.jvmd.api.structures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.actors.impl.ActorImpl;
import io.jvmd.api.actors.impl.SimpleActor;
import io.jvmd.api.world.impl.SimpleBpbWorld;

import java.util.ArrayList;
import java.util.List;

public enum Decoration {
    FLOORS(new String[]{"empty.png", "floor.png"}) {
        @Override
        public Actor getActor(int i) {
            Texture texture = FLOORS.textures.get(i);
            Actor actor = new ActorImpl(new Vector2(0,0), texture);
            return actor;
        }
    },
    HOUSES(new String[]{
        "empty.png", "houses_1.png", "houses_2.png", "houses_3.png", "houses_4.png",
        "houses_5.png", "houses_6.png", "houses_7.png", "houses_8.png", "lean_house.png"
    }) {
        @Override
        public Actor getActor(int i) {
            Texture texture = HOUSES.textures.get(i);
            Actor actor = new SimpleActor(BodyDef.BodyType.StaticBody,texture,
                new Vector2(0, 0), new Vector2(20, 20), HOUSES.getWorld());
            return actor;
        }
    };

    private final String[] textureFiles;
    private final List<Texture> textures = new ArrayList<>();
    private SimpleBpbWorld world;

    Decoration(String[] textureFiles) {
        this.textureFiles = textureFiles;
    }

    public void setWorld(SimpleBpbWorld world) {
        this.world = world;
    }

    public SimpleBpbWorld getWorld() {
        return world;
    }

    public void loadTextures() {
        for (String file : textureFiles) {
            textures.add(new Texture(file));
        }
    }

    public void disposeTextures() {
        for (Texture texture : textures) {
            texture.dispose();
        }
        textures.clear();
    }

    public abstract Actor getActor(int i);
}
