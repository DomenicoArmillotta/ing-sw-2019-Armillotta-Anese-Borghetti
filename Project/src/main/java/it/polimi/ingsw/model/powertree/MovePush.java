package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Worker;

public class MovePush extends Move {

    public int doAction(int[] userInput) {
        Worker floatingWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Cell floatingCell = super.getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition();
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int tempX,tempY;
        super.doAction(userInput);
        if(floatingWorker==null){
            return 0;
        }else {
            if(!super.getAvailableCells().contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                tempX = floatingWorker.getCurrentPosition().getX() - selectedWorker.getCurrentPosition().getX();
                tempY = floatingWorker.getCurrentPosition().getY() - selectedWorker.getCurrentPosition().getY();
                tempX = floatingWorker.getCurrentPosition().getX() + tempX;
                tempY = tempY + floatingWorker.getCurrentPosition().getY();
                floatingWorker.setPreviousPosition(floatingWorker.getCurrentPosition());
                floatingWorker.setCurrentPosition(super.getExecutorPointer().getMap()[tempX][tempY]);
                return 0;
            }else
                return -1;
        }
    }
}
