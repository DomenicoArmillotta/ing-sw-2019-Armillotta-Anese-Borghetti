package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.virtualview.listeners.NoUpdatesListener;

public class EventsBuffer {
    EventBean lastEventBean;
    boolean waiting;

    private static EventsBuffer instance;

    public static EventsBuffer instance() {
        if (instance == null) {
            instance = new EventsBuffer();
        }
        return instance;
    }

    public void setLastEventBean(EventBean lastEventBean) {
        this.lastEventBean = lastEventBean;
    }

    public EventBean getLastEventBean() {
        return lastEventBean;
    }

    public void flushBuffer() {
        lastEventBean = null;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public boolean isWaiting() {
        return waiting;
    }
}
