package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerSelectionEvent;

/**
 * manages the selection of workers in the selection phase
 */
public class Select extends LimitedPower {

    /* Select can use its superclass' method getAvailableCells() */

    private Worker selectedWorker;

    public Worker getSelectedWorker() {
        return this.selectedWorker;
    }

    public void setSelectedWorker(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    /**
     * if the coordinates are null send actionFailed to server
     * if the coordinates coincide with the first worker select the first,
     * if they coincide with the second worker then select the second
     * in other cases none of the workers have been selected
     * it also checks whether the selected worker can move
     * @param userInput the integer coordinates of the Worker to be selected
     * @return
     */
    @Override
    public int doAction(int[] userInput) {
        System.out.println("In select");
        if (userInput == null) {
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY] Action failed: userInput missing */
        } else {
            int index;
            int selectedWorkerX = userInput[0];
            int selectedWorkerY = userInput[1];
            Cell[][] map = getExecutorPointer().getMap();
            if (map[selectedWorkerX][selectedWorkerY].getWorkerOnCell() == getExecutorPointer().getCurrentPlayer().getFirstWorker()) {
                index = 0; /* firstWorker selected */
            } else if (map[selectedWorkerX][selectedWorkerY].getWorkerOnCell() == getExecutorPointer().getCurrentPlayer().getSecondWorker()) {
                index = 1; /* secondWorker selected */
            } else {
                pointerBack();
                getFailedActionListener().actionFailed(new FailedActionEvent(this));
                return -1; /* [NOTIFY] Action failed: user did not select correct Worker */
            }
            if (getExecutorPointer().getNextMove().getAvailableCells(index) != null) { /* This is an additional control */
                if (super.getExecutorPointer().getNextMove().getAvailableCells(index).isEmpty()) {
                    pointerBack();
                    getFailedActionListener().actionFailed(new FailedActionEvent(this));
                    return -1;  /* [NOTIFY] Action failed: selected Worker cannot move after selection */
                }
                setSelectedWorker(map[selectedWorkerX][selectedWorkerY].getWorkerOnCell());
                getWorkerSelectionListener().workerSelected(new WorkerSelectionEvent(map[selectedWorkerX][selectedWorkerY].getWorkerOnCell()));
                getWaitingForActionListener().waitForAction(new WaitingForActionEvent(getExecutorPointer().getNextMove().getAvailableCells(index)));
                return 0;  /* [NOTIFY] Action successful: Worker properly selected */
            } else {
                pointerBack();
                getFailedActionListener().actionFailed(new FailedActionEvent(this));
                return -1;  /* [NOTIFY] Action failed: selected Worker cannot move after selection */
            }
        }
    }

    @Override
    public void clearPower() {
        super.clearPower();
        selectedWorker = null;
    }

}
