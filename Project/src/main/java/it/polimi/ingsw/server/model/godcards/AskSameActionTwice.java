package it.polimi.ingsw.server.model.godcards;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CorrectPromptAnswer;
import it.polimi.ingsw.server.model.mvevents.eventbeans.NoUpdatesEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

public class AskSameActionTwice implements BooleanRequestAction {
    /**
     * manage the reply of the player , in the if statement if received a True reply the controller skips over that move and automatically
     * goes on to the next one.
     * else move the powerPointer to the next action and signals the players of the choice made.
     * @param controller use controller to execute a particular power
     * @param promptChoice
     */
    @Override
    public void BooleanRequestStrategy(Controller controller,Boolean promptChoice) {
        int[] userInput = new int[2];
        if(!promptChoice){
            userInput[0] = ActionExecutor.instance().getPrevSelect().getSelectedWorker().getCurrentPosition().getX();
            userInput[1] = ActionExecutor.instance().getPrevSelect().getSelectedWorker().getCurrentPosition().getY();
            controller.setUserInput(userInput);
            controller.control();
        }
        else
            EventsBuffer.instance().setLastEventBean(new NoUpdatesEventBean());

        EventsBuffer.instance().setLastEventBean(new CorrectPromptAnswer(promptChoice));
    }
}
