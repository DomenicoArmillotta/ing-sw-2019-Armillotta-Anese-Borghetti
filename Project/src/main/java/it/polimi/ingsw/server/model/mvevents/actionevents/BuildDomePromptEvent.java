package it.polimi.ingsw.server.model.mvevents.actionevents;


import it.polimi.ingsw.server.model.mvevents.eventbeans.DomePromptEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class BuildDomePromptEvent extends BooleanRequestEvent {
    @Override
    public EventBean eventMethod() {
        return new DomePromptEventBean();
    }
}

