package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public abstract class BooleanRequestEvent extends ActionEvent{
    @Override
    public abstract EventBean eventMethod();
}