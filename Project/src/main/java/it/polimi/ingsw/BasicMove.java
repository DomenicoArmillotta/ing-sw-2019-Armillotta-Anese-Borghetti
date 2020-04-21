package it.polimi.ingsw;

import java.util.List;

public class BasicMove extends SelectMove {
    //Worker selectedWorker;
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = super.getAvailableCells();
        if (super.getAvailableCells() != null &&
                userInput[0] == super.getSelectedWorker().getCurrentPosition().getX() &&
                userInput[1] == super.getSelectedWorker().getCurrentPosition().getY() &&
                userInput[2] == super.getAvailableCells().get(0).getX() &&
                userInput[3] == super.getAvailableCells().get(0).getY()) {
            return 0;
        } else {
            return -1;
        }
    }
}
