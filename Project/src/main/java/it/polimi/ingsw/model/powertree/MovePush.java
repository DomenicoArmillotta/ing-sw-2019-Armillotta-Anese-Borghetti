package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Worker;

public class MovePush extends Move {

    public int doAction(int[] userInput) {
        Worker targetWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int tempX=0,tempY=0;
        int oldX = selectedWorker.getCurrentPosition().getX();
        int oldY = selectedWorker.getCurrentPosition().getY();
        super.doAction(userInput);
        if(targetWorker==null){
            return 0;
        }else {
            if (super.getAvailableCells(0).contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                tempX = targetWorker.getCurrentPosition().getX() - oldX;
                tempY = targetWorker.getCurrentPosition().getY() - oldY;
                tempX = targetWorker.getCurrentPosition().getX() + tempX;
                tempY = targetWorker.getCurrentPosition().getY() + tempY;
                targetWorker.setPreviousPosition(targetWorker.getCurrentPosition());
                targetWorker.getPreviousPosition().setWorkerOnCell(selectedWorker);
                targetWorker.setCurrentPosition(super.getExecutorPointer().getMap()[tempX][tempY]);
                targetWorker.getCurrentPosition().setWorkerOnCell(targetWorker);
                return 0;
            } else
                return -1;
        }
    }
}
