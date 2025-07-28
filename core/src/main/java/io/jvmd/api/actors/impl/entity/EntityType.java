package io.jvmd.api.actors.impl.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import io.jvmd.api.actors.impl.AnimatedActor;
import io.jvmd.input.BPBInputProcessor;


public enum EntityType {

    // todo make a move method abstarct and implement it in each enum  in enemy and peacefulentity with AI module

    PLAYER {
        Vector2 camertaPosition = new Vector2();
        //todo make a settings lerp
        float lerp = 0.01f;


        @Override
        public void move(Vector2 direction) {

            direction.x *= PLAYER.SPEED;
            direction.y *= PLAYER.SPEED;
            getBody().setPosition(getBody().getPosition().add(direction));
            OrthographicCamera camera = getBody().getCamera();
            camertaPosition.lerp(getBody().getPosition(), lerp);

            camera.position.x = camertaPosition.x;
            camera.position.y = camertaPosition.y;

        }

    },
    PEACEFULENTITY {
        @Override
        protected void move(Vector2 direction) {

        }
    },
    ENEMY {
        private int damage = 10;

        public void damage(Entity entity) {
            entity.setHealthPoint(entity.getHealthPoint() - damage);
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        @Override
        protected void move(Vector2 direction) {

        }
    };


    private float SPEED = 1f;
    private static final int defaultHealth = 100;
    private int health;
    private AnimatedActor body;
    private BPBInputProcessor input;

    EntityType() {
        this.health = defaultHealth;
    }

    protected abstract void move(Vector2 direction);

    protected void move() {
        move(input.getDirection());
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public void setInputProcessor(BPBInputProcessor processor) {
        this.input = processor;
    }

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected AnimatedActor getBody() {
        return body;
    }

    protected void setBody(AnimatedActor body) {
        this.body = body;
    }
}
