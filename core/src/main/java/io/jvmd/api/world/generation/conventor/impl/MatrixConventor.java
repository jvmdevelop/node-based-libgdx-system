package io.jvmd.api.world.generation.conventor.impl;

import com.badlogic.gdx.math.Vector2;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.actors.impl.ActorImpl;
import io.jvmd.api.actors.impl.SimpleActor;
import io.jvmd.api.structures.Decoration;
import io.jvmd.api.world.generation.conventor.Conventor;
import io.jvmd.api.world.impl.SimpleBpbWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.WeakHashMap;

public class MatrixConventor implements Conventor<SimpleBpbWorld, int[][]> {
    @Override
    public SimpleBpbWorld convent(int[][] matrix) {
        SimpleBpbWorld world = new SimpleBpbWorld();
        world.setup();
        List<Actor> actors = new ArrayList<>();
        Decoration floors = Decoration.FLOORS;
        Decoration houses = Decoration.HOUSES;
        Random random = new Random();
        houses.setWorld(world);
        floors.setWorld(world);
        floors.loadTextures();
        houses.loadTextures();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] == 1 || matrix[x][y] == 2) {
                    ActorImpl actor = (ActorImpl) floors.getActor(1);
                    actor.setPosition(new Vector2(y*128, x*128));
                    actors.add(actor);
                }else if (matrix[x][y] == 0) {
                    SimpleActor actor = (SimpleActor) houses.getActor(random.nextInt(1,10));
                    actor.setPosition(new Vector2(y*128, x*128));
                    actors.add(actor);
                }
            }
        }


        world.addActors(actors);

        return world;
    }
}
