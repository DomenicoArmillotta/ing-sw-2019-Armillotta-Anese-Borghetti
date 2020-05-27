package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.BooleanRequestEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.DoubleMoveEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.powertree.DoubleMove;

public class BooleanActionListener extends Listener {

    private static BooleanActionListener instance;

    public static BooleanActionListener instance() {
        if (instance == null) {
            instance = new BooleanActionListener();
        }
        return instance;
    }

    public void createPromptBean(BooleanRequestEvent doubleBooleanRequest) {
        EventBean eventBean =  doubleBooleanRequest.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        eventsBuffer.setWaiting(false);
        /* send event to clients */
    }
}
