package it.polimi.ingsw;

import java.util.List;

public class BasicMove extends SelectMove {
    Worker selectedWorker;
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = super.getAvailableCells();
        if (userInput[0] == super.selectedWorker.getCurrentPosition().getX() &&
                userInput[1] == super.selectedWorker.getCurrentPosition().getY() &&
                (userInput[2] == availableCells.get(0).getX() &&
                        userInput[3] == availableCells.get(0).getY()) ||
                (userInput[2] == availableCells.get(1).getX() &&
                        userInput[3] == availableCells.get(1).getY())) {
            return 0;
        } else {
            return -1;
        }
    }
}
