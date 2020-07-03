package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.actionevents.BuildDomePromptEvent;

/**
 * manage boolean requests for building a dome
 */
public class BuildDomePrompt extends Power{
    @Override
    public int doAction(int[] userInput) {
        ActionExecutor actionExecutor = ActionExecutor.instance();
        int selectedWorker;
        if(actionExecutor.getPrevSelect().getSelectedWorker().equals(actionExecutor.getCurrentPlayer().getFirstWorker()))
            selectedWorker = 0;
        else
            selectedWorker = 1;

        if(actionExecutor.getNextBuild().getAvailableCells(selectedWorker).size() == 0) {
            return 1; // non ci sono celle disponibili per questo worker quindi passiamo oltre
        }else{
            super.getBooleanActionListener().createPromptBean(new BuildDomePromptEvent());
        }
        return 0;
    }
}
