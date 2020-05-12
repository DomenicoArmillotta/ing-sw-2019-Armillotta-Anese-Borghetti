package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class PlayerWonListener extends Listener {

    private static PlayerWonListener instance;

    public static PlayerWonListener instance() {
        if (instance == null) {
            instance = new PlayerWonListener();
        }
        return instance;
    }

    public void winGame(PlayerWonEvent playerWonEvent) {
        eventsBuffer.flushBuffer();
        EventBean eventBean = playerWonEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        eventsBuffer.setWaiting(false);
        /* send event to clients */
    }

}
