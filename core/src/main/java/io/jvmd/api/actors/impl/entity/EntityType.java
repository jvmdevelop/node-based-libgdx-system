package io.jvmd.api.actors.impl.entity;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import io.jvmd.api.actors.Actor;
import io.jvmd.api.actors.impl.AnimatedActor;
import io.jvmd.user.input.UserInput;

public enum EntityType {

    // todo make a move mathod abstarct and implement it in each enum  in enemy and peacefulentity with AI module

    PLAYER {
        private UserInput userInput;

        public void move(){
            move(userInput.getDirection());
        }

        private void move(Vector2 direction) {
                        direction.x  *= PLAYER.SPEED;
                        direction.y  *= PLAYER.SPEED;
                        getBody().setPosition(direction);
        }

        public void setInputProcessor(UserInput processor) {
            this.userInput = processor;
        }
    },
    PEACEFULENTITY,
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
    };

    private int SPEED = 10;
    private static final int defaultHealth = 100;
    private int health;
    private AnimatedActor body;

    EntityType() {
        this.health = defaultHealth;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
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
