package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.NoUpdatesEventBean;

public class NoUpdatesEvent extends ActionEvent {

    public NoUpdatesEvent() {
        ;
    }

    public EventBean eventMethod() {
        NoUpdatesEventBean noUpdatesEventBean = new NoUpdatesEventBean();
        return noUpdatesEventBean;
    }
}
