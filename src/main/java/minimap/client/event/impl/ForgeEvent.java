package minimap.client.event.impl;

import minimap.client.event.types.Event;

public class ForgeEvent extends Event {

    private final net.minecraftforge.fml.common.eventhandler.Event event;

    public ForgeEvent(net.minecraftforge.fml.common.eventhandler.Event event) {
        this.event = event;
    }

    public net.minecraftforge.fml.common.eventhandler.Event getEvent() {
        return event;
    }

}
