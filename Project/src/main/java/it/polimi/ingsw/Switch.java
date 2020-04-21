package it.polimi.ingsw;

import java.util.List;

public class Switch extends BasicMove {
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = super.getAvailableCells();
        if (super.doAction(userInput) == 0) {
            return 0;
        } else return -1;


    }
}
