package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.DoubleBuildEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class DoubleBuildEvent extends BooleanRequestEvent{
    @Override
    public EventBean eventMethod() {
        return new DoubleBuildEventBean();
    }
}
