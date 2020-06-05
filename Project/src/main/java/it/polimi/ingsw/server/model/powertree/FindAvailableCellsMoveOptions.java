package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

public class FindAvailableCellsMoveOptions extends FindAvailableCellsMove {
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(userInput) == 0) {
            getWaitingForActionListener().waitForAction(new WaitingForActionEvent(getExecutorPointer().getNextMove().getAvailableCells(getWorkerIndex())));
            return 0;
        } else
            return -1;
    }
}
