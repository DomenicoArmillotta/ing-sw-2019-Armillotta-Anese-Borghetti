package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

/* Se non è cupola va normalmente,altrimenti ritorno -1 */
public class DontBuildDome extends Build {

    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = getAvailableCells(0);
        Cell[][] map = getExecutorPointer().getMap();
        /* Cella su cui voglio costruire */
        int blockX = userInput[0];
        int blockY = userInput[1];
        if (map[blockX][blockY].getBuildingLevel().getNext() != Level.DOME) {
            if (super.doAction(userInput) == -1)
                return -1;
            return 0;
        } else {
            pointerBack();
            return -1;
        }
    }

}
