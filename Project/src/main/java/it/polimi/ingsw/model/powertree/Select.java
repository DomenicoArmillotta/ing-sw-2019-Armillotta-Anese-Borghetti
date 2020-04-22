package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class Select extends LimitedPower {

    /* Select can use its superclass' method getAvailableCells() */

    private Worker selectedWorker;

    public Worker getSelectedWorker() {
        return this.selectedWorker;
    }

    @Override
    public void clearPower() {
        super.clearPower();
        selectedWorker = null;
    }

    public void setSelectedWorker(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    @Override
    public int doAction(int[] userInput) { /* userInput contains the integer coordinates of the Worker to be selected */
        if (userInput == null) {
            return -1; /* Action failed: userInput missing */
        } else {

            int selectedWorkerX = userInput[0];
            int selectedWorkerY = userInput[1];
            Player currentPlayer = getExecutorPointer().getCurrentPlayer();
            Cell[][] map = getExecutorPointer().getMap();
            if (getAvailableCells().contains(map[selectedWorkerX][selectedWorkerY])) {


                if (map[selectedWorkerX][selectedWorkerY].getWorkerOnCell().getOwner().equals(currentPlayer)) {

                    System.out.print(map[selectedWorkerX][selectedWorkerY].getWorkerOnCell());
                    setSelectedWorker(map[selectedWorkerX][selectedWorkerY].getWorkerOnCell());
                    return 0;
                } else {
                    return -1; /*Action failed: currentPlayer is not the Worker's owner */
                }
            } else {
                return -1; /*Action failed: chosen Cell is not available for selection */
            }
        }
    }
}
