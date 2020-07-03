package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * when in the server FailedActionEvent is triggered,
 * the corresponding eventBean is created, it is inserted in the buffer which will subsequently be sent
 */
public class FailedActionListener extends Listener {

    private static FailedActionListener instance;

    public static FailedActionListener instance() {
        if (instance == null) {
            instance = new FailedActionListener();
        }
        return instance;
    }

    public void actionFailed(FailedActionEvent failedActionEvent) {
        EventBean eventBean = failedActionEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        /* send event to clients */
    }

}
