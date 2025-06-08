package io.jvmd.api.entity.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Model;
import io.jvmd.api.world.World;
import io.jvmd.api.world.impl.SimpleWorld;

public abstract class Enemy extends Entity {

    private double damage;

    public Enemy(String name, Model model,Camera camera , double health) {
        super(name ,model, camera, health);
    }

    // todo tealize entity container
    public void damageEntity(String name) {
        getWorld().getEntityPool().getObjects().get(name).translateHealth(damage);
    }

    public abstract void calculateDamage(Object... params);


}
