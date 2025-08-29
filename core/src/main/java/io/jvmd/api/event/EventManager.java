package io.jvmd.api.event;

import io.jvmd.api.event.handling.EventHandler;

import java.util.*;

public final class EventManager {

    private static final Set<Event> events = new HashSet<>();

    private static final List<Event> result = new ArrayList<>();

    private static final HashMap<Event, List<EventHandler>> handlers = new HashMap<>();

    public static void addEvent(Event event) {
        events.add(event);
    }

    public static void addEvents(List<Event> events) {
        EventManager.events.addAll(events);
    }

    public static void removeEvent(Event event) {
        events.remove(event);
    }

    public static void handle(Event event) {
        handlers.get(event).forEach((handlers) -> {
            handlers.handleEvent(event);
        });
    }

    public static void observe() {
        result.clear();
        result.forEach((event)->{
            if(event.isHappening()) {
                result.add(event);
            }
        });
    }


    public static void start() {
        observe();
        if(result.isEmpty()) return;
        result.forEach((event)->{
            handle(event);
        });
    }

}
