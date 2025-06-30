package io.jvmd.api.actors.impl.entity;

import io.jvmd.api.actors.impl.AnimatedActor;
import io.jvmd.api.actors.impl.SimpleActor;

public interface Entity  {

        int getName();

        EntityType getType();

        default int getHealthPoint(){
                return getType().getHealth();
        }

    default void setHealthPoint(int healthPoint){
        getType().setHealth(healthPoint);
    }

    default AnimatedActor getBody(){
        return getType().getBody();
    }
    default void setBody(AnimatedActor body){
        getType().setBody(body);
    }


}
