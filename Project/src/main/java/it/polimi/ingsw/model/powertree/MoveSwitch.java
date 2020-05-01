package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

public class MoveSwitch extends Move {

    @Override
    public int doAction(int[] userInput) {
        Worker floatingWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Cell floatingCell = super.getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition();

        if (super.doAction(userInput) == -1) {
            /* Do not call pointerBack(): it has already been called in the superclass */
            return -1;
        }
        if (floatingWorker == null) {
            return 0; /* [NOTIFY]: MoveSwitch successful */
        } else if (super.getAvailableCells(0).contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
            floatingWorker.setPreviousPosition(floatingWorker.getCurrentPosition());
            floatingWorker.getPreviousPosition().setWorkerOnCell(super.getExecutorPointer().getPrevSelect().getSelectedWorker());
            floatingWorker.setCurrentPosition(floatingCell);
            floatingWorker.getCurrentPosition().setWorkerOnCell(floatingWorker);
            /* setState() -> floatingWorker si è mosso da previousPosition a currentPosition */
            return 0; /* [NOTIFY]: MoveSwitch successful */
        } else {
            pointerBack();
            return -1; /* [NOTIFY]: MoveSwitch failed */
        }
    }

}
