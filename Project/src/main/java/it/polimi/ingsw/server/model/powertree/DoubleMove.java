package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.actionevents.DoubleMoveEvent;

public class DoubleMove extends Power{

    @Override
    public int doAction(int[] userInput) {
        /* prendo le available cells e vedo che fare*/
        /*creo nuovi listener*/
        ActionExecutor actionExecutor = ActionExecutor.instance();
        int selectedWorker;
        if(actionExecutor.getPrevSelect().getSelectedWorker().equals(actionExecutor.getCurrentPlayer().getFirstWorker()))
            selectedWorker = 0;
        else
            selectedWorker = 1;

        if(actionExecutor.getNextMove().getAvailableCells(selectedWorker).size() == 0) {
            return 1; // non ci sono celle disponibili per questo worker quindi passiamo oltre
        }else{
            super.getBooleanActionListener().createPromptBean(new DoubleMoveEvent());
        }
        return 0;
    }
}
