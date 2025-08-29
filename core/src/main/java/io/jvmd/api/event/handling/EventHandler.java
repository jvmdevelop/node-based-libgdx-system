package io.jvmd.api.event.handling;


import io.jvmd.api.event.Event;

public interface EventHandler {

    void handleEvent(Event event);

}
