package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.DoubleBuildEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * event that is generated when a player do the double build
 */
public class DoubleBuildEvent extends BooleanRequestEvent{
    @Override
    public EventBean eventMethod() {
        return new DoubleBuildEventBean();
    }
}
