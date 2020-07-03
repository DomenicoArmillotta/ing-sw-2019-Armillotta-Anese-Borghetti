package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.DoubleMoveEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * event that is generated when a player do the double move
 */
public class DoubleMoveEvent extends BooleanRequestEvent{

    @Override
    public EventBean eventMethod(){
        return new DoubleMoveEventBean();
    }
}
