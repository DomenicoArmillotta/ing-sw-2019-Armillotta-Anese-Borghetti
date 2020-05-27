package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.DoubleMoveEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class DoubleMoveEvent extends BooleanRequestEvent{

    @Override
    public EventBean eventMethod(){
        return new DoubleMoveEventBean();
    }
}
