package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

/**
 * it's a boolean event and it's used for boolean request
 */
public abstract class BooleanRequestEvent extends ActionEvent{
    @Override
    public abstract EventBean eventMethod();
}
