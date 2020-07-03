package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

/**
 * prototype of Listener class, contains eventsBuffer
 */
public abstract class Listener {

    protected EventsBuffer eventsBuffer = EventsBuffer.instance();

}
