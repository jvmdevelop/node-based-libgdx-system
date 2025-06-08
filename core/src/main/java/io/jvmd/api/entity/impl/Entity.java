package io.jvmd.api.entity.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector3;

public abstract class Entity extends SimpleObject {

    private double health;


    public Entity(String name, Model model, Camera camera, double health) {
        super(name, model, camera);
        this.health = health;
    }

    public void translateHealth(double damage) {
        health = health - damage;
    }

    @Override
    public void update() {
        super.update();
        if (getPosition().y > 5) {
            setPosition(new Vector3(getPosition().x, getPosition().y - 1 , getPosition().z));
        }
    }

    public abstract void walk();
    public abstract void jump();

}
