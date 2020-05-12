package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class FailedActionListener extends Listener {

    private static FailedActionListener instance;

    public static FailedActionListener instance() {
        if (instance == null) {
            instance = new FailedActionListener();
        }
        return instance;
    }

    public void actionFailed(FailedActionEvent failedActionEvent) {
        eventsBuffer.flushBuffer();
        EventBean eventBean = failedActionEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        eventsBuffer.setWaiting(true);
        /* send event to clients */
    }

}
