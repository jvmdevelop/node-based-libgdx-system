package io.jvmd.api.world.generation.conventor.impl;

import com.badlogic.gdx.math.Vector2;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.actors.impl.SimpleActor;
import io.jvmd.api.structures.Decoration;
import io.jvmd.api.world.generation.conventor.Conventor;
import io.jvmd.api.world.impl.SimpleBpbWorld;

import java.util.ArrayList;
import java.util.List;

public class MatrixConventor implements Conventor<SimpleBpbWorld, Integer[][]> {
    @Override
    public SimpleBpbWorld convent(Integer[][] matrix) {
        List<Actor> actors = new ArrayList<>();

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] == 1 || matrix[x][y] == 2) {
                    SimpleActor actor = (SimpleActor) Decoration.FLOORS.getActor(2);
                    actor.setPosition(new Vector2(x, y));
                    actors.add(actor);
                }
            }
        }

        SimpleBpbWorld world = new SimpleBpbWorld();
        world.addActors(actors);

        return world;
    }
}
