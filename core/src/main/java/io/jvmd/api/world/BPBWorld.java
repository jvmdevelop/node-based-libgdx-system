package io.jvmd.api.world;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;
import io.jvmd.api.actors.Actor;

import java.util.HashMap;
import java.util.Map;

public interface BPBWorld {



    class ObjectIndexer {
        private final Map<Actor , Integer> indexes = new HashMap<>();
        public int giveIndex(Actor actor) {
            int index = indexes.size();
            indexes.put(actor, index);
            return index;
        }

        public int getIndex(Actor actor) {
            return indexes.get(actor);
        }
    }


    void setup();
    void render();
    void addActor(Actor actor);
    void removeActor(Actor actor);
    void setCamera(Camera camera);

    World getWorld();
    void setBatch(Batch batch);
}
