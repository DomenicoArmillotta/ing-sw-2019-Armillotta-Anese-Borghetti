package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class WaitingForActionListener extends Listener {

    private static WaitingForActionListener instance;

    public static WaitingForActionListener instance() {
        if (instance == null) {
            instance = new WaitingForActionListener();
        }
        return instance;
    }

    public void waitForAction(WaitingForActionEvent waitingForActionEvent) {
        EventBean eventBean = waitingForActionEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        eventsBuffer.setWaiting(true);
        /* send event to clients */
    }

}
