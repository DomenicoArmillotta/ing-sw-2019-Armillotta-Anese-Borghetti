package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.BuildOrMoveEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

/**
 * it's a boolean event and ask if you would build or move
 */
public class BuildOrMoveEvent extends  BooleanRequestEvent{
    @Override
    public EventBean eventMethod() {
        return new BuildOrMoveEventBean();
    }
}
