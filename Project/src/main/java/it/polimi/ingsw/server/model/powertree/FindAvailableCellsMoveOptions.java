package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

/**
 * special case for a god that move after has build
 */
public class FindAvailableCellsMoveOptions extends FindAvailableCellsMove {
    /**
     * return 0 if teh action was successful else -1
     * @param userInput user input from the cli or gui
     * @return -1 if action fail else 0
     */
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(userInput) == 0) {
            getWaitingForActionListener().waitForAction(new WaitingForActionEvent(getExecutorPointer().getNextMove().getAvailableCells(getWorkerIndex())));
            return 0;
        } else
            return -1;
    }
}
