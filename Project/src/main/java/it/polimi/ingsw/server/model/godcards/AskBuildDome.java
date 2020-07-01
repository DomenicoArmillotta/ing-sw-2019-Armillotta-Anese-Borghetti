package it.polimi.ingsw.server.model.godcards;
import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CorrectPromptAnswer;
import it.polimi.ingsw.server.model.mvevents.eventbeans.NoUpdatesEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

public class AskBuildDome implements BooleanRequestAction{
    @Override
    public void BooleanRequestStrategy(Controller controller, Boolean booleanChoice) {
        /*
        la Dome dovra passare al controller le informazioni per la build
         */
        int[] userInput = new int[2];
        if(!booleanChoice) {
            userInput[0] = ActionExecutor.instance().getPrevSelect().getSelectedWorker().getCurrentPosition().getX();
            userInput[1] = ActionExecutor.instance().getPrevSelect().getSelectedWorker().getCurrentPosition().getY();
            controller.setUserInput(userInput);
            controller.control();
        }else
            EventsBuffer.instance().setLastEventBean(new NoUpdatesEventBean());

        EventsBuffer.instance().setLastEventBean(new CorrectPromptAnswer(booleanChoice));
    }
}
