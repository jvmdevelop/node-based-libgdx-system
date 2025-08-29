package io.jvmd.api.event.impl;

import io.jvmd.api.event.Event;

import java.util.HashMap;
import java.util.function.Function;

public abstract class AbsEvent implements Event {

    @Override
    public boolean isConditionHappening(Object object) {
        return getConditions().get(object).apply(this);
    }

    @Override
    public boolean isHappening() {

        getConditions().values().stream().allMatch((object) -> object.apply(object));

        return false;
    }
}
