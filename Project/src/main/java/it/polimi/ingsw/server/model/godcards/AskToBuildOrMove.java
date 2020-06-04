package it.polimi.ingsw.server.model.godcards;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.eventbeans.NoUpdatesEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

public class AskToBuildOrMove implements BooleanRequestAction{
    @Override
    public void BooleanRequestStrategy(Controller controller, Boolean booleanChoice) {
        /* true = costruisci; false = non costruisci */
        if(!booleanChoice) {
            ActionExecutor.instance().getNextPower().doAction(null);
        } else {
            EventsBuffer.instance().setLastEventBean(new NoUpdatesEventBean());
        }
    }
}
