package io.jvmd.api.event;


import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public interface Event {

    HashMap<String , Function<Object, Boolean>> getConditions();
    boolean isConditionHappening(Object object);
    boolean isHappening();

}
