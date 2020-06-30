package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.actionevents.DoubleMoveEvent;

/**
 *  check if a worker is able to move another time after their previous move.
 */
public class DoubleMove extends Power{

    /**
     * @return 1 if worker ins not able to perform another move else 0 and notify woith DoubleMoveEvent
     */
    @Override
    public int doAction(int[] userInput) {
        ActionExecutor actionExecutor = super.executorPointer;
        int selectedWorker = getWorkerIndex();

        if(actionExecutor.getNextMove().getAvailableCells(selectedWorker).size() == 0) {
            return 1;
        }else{
            super.getBooleanActionListener().createPromptBean(new DoubleMoveEvent());
        }
        return 0;
    }
}
