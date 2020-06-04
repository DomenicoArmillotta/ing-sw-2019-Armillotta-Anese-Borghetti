package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.actionevents.BuildOrMoveEvent;

public class BuildOrMovePrompt extends Power{
    @Override
    public int doAction(int[] userInput) {
        ActionExecutor actionExecutor = ActionExecutor.instance();
        int selectedWorker;
        if(actionExecutor.getPrevSelect().getSelectedWorker().equals(actionExecutor.getCurrentPlayer().getFirstWorker()))
            selectedWorker = 0;
        else
            selectedWorker = 1;
        if(actionExecutor.getNextBuild().getAvailableCells(selectedWorker).size() == 0)
            return 1;
        else
            getBooleanActionListener().createPromptBean(new BuildOrMoveEvent());
            return 0;

    }
}
