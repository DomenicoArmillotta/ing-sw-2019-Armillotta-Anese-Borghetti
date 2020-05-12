package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class NoUpdatesListener extends Listener {

    private static NoUpdatesListener instance;

    public static NoUpdatesListener instance() {
        if (instance == null) {
            instance = new NoUpdatesListener();
        }
        return instance;
    }

    public void noUpdates(NoUpdatesEvent noUpdatesEvent) {
        eventsBuffer.flushBuffer();
        EventBean eventBean = noUpdatesEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        eventsBuffer.setWaiting(false);
        /* send event to clients */
    }

}
