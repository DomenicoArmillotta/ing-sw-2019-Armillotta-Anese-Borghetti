package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Worker;

public class MovePush extends Move {

    public int doAction(int[] userInput) {
        Worker targetWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int tempX = 0, tempY = 0;
        int oldX = selectedWorker.getCurrentPosition().getX();
        int oldY = selectedWorker.getCurrentPosition().getY();
        if (super.doAction(userInput) == -1)
            return -1;
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) {
            index = 0;
        } else index = 1;

        if (targetWorker == null) {
            return 0;
        } else {
            if (super.getAvailableCells(index).contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                tempX = targetWorker.getCurrentPosition().getX() - oldX;
                tempY = targetWorker.getCurrentPosition().getY() - oldY;
                tempX = targetWorker.getCurrentPosition().getX() + tempX;
                tempY = targetWorker.getCurrentPosition().getY() + tempY;
                targetWorker.setPreviousPosition(targetWorker.getCurrentPosition());
                targetWorker.getPreviousPosition().setWorkerOnCell(selectedWorker);
                targetWorker.setCurrentPosition(super.getExecutorPointer().getMap()[tempX][tempY]);
                targetWorker.getCurrentPosition().setWorkerOnCell(targetWorker);
                return 0;
            } else {
                PointerBack();
                return -1;
            }
        }
    }
}
