package minimap.client.event.types;

import minimap.client.event.EventTiming;

public interface IEventTiming {

    EventTiming getTiming();

    default boolean isPre() {
        return getTiming() == EventTiming.PRE;
    }

    default boolean isPost() {
        return getTiming() == EventTiming.POST;
    }

}
