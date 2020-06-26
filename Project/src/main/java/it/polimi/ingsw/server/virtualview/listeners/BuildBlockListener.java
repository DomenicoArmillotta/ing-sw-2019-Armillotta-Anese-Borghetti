package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.BuildBlockEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class BuildBlockListener extends Listener {

    private static BuildBlockListener instance;

    public static BuildBlockListener instance() {
        if (instance == null) {
            instance = new BuildBlockListener();
        }
        return instance;
    }

    public void buildBlock(BuildBlockEvent buildBlockEvent) {
        EventBean eventBean = buildBlockEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        /* send event to clients */
    }

}
