package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class Switch extends FindAvailableCells {
    int num;

    public int doAction(int[] userInput) {

        List<Cell> availableCells;

        super.doAction(userInput);
        availableCells = super.executorPointer.getNextLimitedAction().getAvailableCells();
        /* aggiungo le celle con worker avversari */
        if (super.loseCheck(availableCells) == true) {
        }
        super.executorPointer.getNextLimitedAction().setAvailableCells(availableCells);

        return 0;
    }

}
