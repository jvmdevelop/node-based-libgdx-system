package io.jvmd.api.structures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.actors.impl.SimpleActor;
import io.jvmd.api.world.impl.SimpleBpbWorld;

import java.util.*;

public enum Decoration {
    TABLES {
        @Override
        public List<Actor> getVariates() {
            List<String> variates = new ArrayList<String>() {
                {
                    add("empty.png");
                    add("player.png");
                }
            };
            List<Actor> actors = new ArrayList<>();

            return actors;
        }
    },
    ITEMS {
        @Override
        public List<Actor> getVariates() {
            List<String> variates = new ArrayList<String>() {
                {
                    add("empty.png");
                    add("player.png");
                }
            };
            List<Actor> actors = new ArrayList<>();


            return actors;
        }
    },
    FLOORS {
        @Override
        public List<Actor> getVariates() {
            List<String> variates = new ArrayList<String>() {
                {
                    add("empty.png");
                    add("player.png");
                }
            };

            List<Actor> actors = new ArrayList<>();

            variates.forEach((element)-> {
                SimpleActor actor = new SimpleActor(BodyDef.BodyType.StaticBody , new Vector2(0,0) , new Vector2(10 , 10) , getWorld());
                actor.setTexture(new Texture(element));
                actors.add(actor);
            });

            return actors;
        }
    };

    private SimpleBpbWorld  world;

    public SimpleBpbWorld getWorld() {
        return world;
    }

    public void setWorld(SimpleBpbWorld world) {
        this.world = world;
    }

    public abstract List<Actor> getVariates();

    public Actor getActor(int i) {
       return getVariates().get(i);
    }


}
