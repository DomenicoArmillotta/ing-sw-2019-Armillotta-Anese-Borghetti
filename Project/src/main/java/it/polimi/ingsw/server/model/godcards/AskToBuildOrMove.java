package it.polimi.ingsw.server.model.godcards;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CorrectPromptAnswer;
import it.polimi.ingsw.server.model.mvevents.eventbeans.NoUpdatesEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.WaitingForActionEventBean;
import it.polimi.ingsw.server.model.powertree.FindAvailableCellsMoveButDontMoveUp;
import it.polimi.ingsw.server.virtualview.listeners.NoUpdatesListener;
import it.polimi.ingsw.server.virtualview.listeners.WaitingForActionListener;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

public class AskToBuildOrMove implements BooleanRequestAction{
    @Override
    public void BooleanRequestStrategy(Controller controller, Boolean booleanChoice) {
        /* true = costruisci; false = non costruisci */
        if(!ActionExecutor.instance().getCurrentPlayer().getPlayerGod().getMoveLimitationsList().isEmpty())
            ActionExecutor.instance().getCurrentPlayer().getPlayerGod().getMoveLimitationsList().clear();
        if(!booleanChoice) {
            controller.setUserInput(null);
            controller.control();
            /* ActionExecutor.instance().getNextPower().doAction(null);
            ActionExecutor.instance().getNextPower().doAction(null); */
        } else {
            NoUpdatesListener.instance().noUpdates(new NoUpdatesEvent());
            //WaitingForActionListener.instance().waitForAction(new WaitingForActionEvent(ActionExecutor.instance().getNextMove().getAvailableCells(index)));
            ActionExecutor.instance().getCurrentPlayer().getPlayerGod().addMoveLimitations(new FindAvailableCellsMoveButDontMoveUp());
        }

        EventsBuffer.instance().setLastEventBean(new CorrectPromptAnswer(booleanChoice));
    }
}
