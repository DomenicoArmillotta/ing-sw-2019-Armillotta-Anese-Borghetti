package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * when in the server playerWonEvent is triggered,
 * the corresponding eventBean is created, it is inserted in the buffer which will subsequently be sent
 */
public class PlayerWonListener extends Listener {

    private static PlayerWonListener instance;

    public static PlayerWonListener instance() {
        if (instance == null) {
            instance = new PlayerWonListener();
        }
        return instance;
    }

    public void winGame(PlayerWonEvent playerWonEvent) {
        EventBean eventBean = playerWonEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        /* send event to clients */
    }

}
