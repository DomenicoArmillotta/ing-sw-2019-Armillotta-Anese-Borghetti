package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * when in the server noUpdatesEvent is triggered,
 * the corresponding eventBean is created, it is inserted in the buffer which will subsequently be sent
 */
public class NoUpdatesListener extends Listener {

    private static NoUpdatesListener instance;

    public static NoUpdatesListener instance() {
        if (instance == null) {
            instance = new NoUpdatesListener();
        }
        return instance;
    }

    public void noUpdates(NoUpdatesEvent noUpdatesEvent) {
        EventBean eventBean = noUpdatesEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        /* send event to clients */
    }

}
