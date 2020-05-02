package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.virtualview.WorkerSelectionListener;

public class Select extends LimitedPower {

    /* Select can use its superclass' method getAvailableCells() */

    private Worker selectedWorker;

    private WorkerSelectionEvent lastEvent;

    public Worker getSelectedWorker() {
        return this.selectedWorker;
    }

    public void setSelectedWorker(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    @Override
    public int doAction(int[] userInput) { /* userInput contains the integer coordinates of the Worker to be selected */
        if (userInput == null) {
            pointerBack();
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
                return -1; /* [NOTIFY] Action failed: user did not select correct Worker */
            }
            if (getExecutorPointer().getNextMove().getAvailableCells(index) != null) { /* This is an additional control */
                if (super.getExecutorPointer().getNextMove().getAvailableCells(index).isEmpty()) {
                    pointerBack();
                    return -1;  /* [NOTIFY] Action failed: selected Worker cannot move after selection */
                }
                setSelectedWorker(map[selectedWorkerX][selectedWorkerY].getWorkerOnCell());
                setState(new WorkerSelectionEvent(selectedWorker));
                notifyListeners();
                return 0;  /* [NOTIFY] Action successful: Worker properly selected */
            } else {
                pointerBack();
                return -1;  /* [NOTIFY] Action failed: selected Worker cannot move after selection */
            }
        }
    }

    @Override
    public void clearPower() {
        super.clearPower();
        selectedWorker = null;
    }

    @Override
    public WorkerSelectionEvent getState() {
        return lastEvent;
    }

    public void setState(WorkerSelectionEvent lastEvent) {
        this.lastEvent = lastEvent;
    }

}
