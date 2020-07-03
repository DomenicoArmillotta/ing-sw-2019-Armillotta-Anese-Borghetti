package it.polimi.ingsw.server.virtualview.listeners;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerLostEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * when the server PlayerLostEvent is triggered,
 * the corresponding eventBean is created, it is inserted in the buffer which will subsequently be sent
 */
public class PlayerLostListener extends Listener {

    private static PlayerLostListener instance;

    public static PlayerLostListener instance() {
        if (instance == null) {
            instance = new PlayerLostListener();
        }
        return instance;
    }

    public void loseGame(PlayerLostEvent playerLostEvent) {
        EventBean eventBean = playerLostEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        /* send event to clients */
    }

}
