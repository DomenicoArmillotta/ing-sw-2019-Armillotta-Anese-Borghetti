package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

/**
 * prototype of every event that the model create to notify the view of a change in its status
 */
public abstract class ActionEvent {
    abstract public EventBean eventMethod();
}
