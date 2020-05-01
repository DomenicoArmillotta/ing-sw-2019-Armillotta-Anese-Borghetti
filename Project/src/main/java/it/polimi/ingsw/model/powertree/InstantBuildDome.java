package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

/* Forzo costruzione cupola dove si può costruire */
public class InstantBuildDome extends Build {
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = getAvailableCells(0);
        Cell[][] map = getExecutorPointer().getMap();
        /* Cella su cui voglio costruire */
        int blockX = userInput[0];
        int blockY = userInput[1];
        if (availableCells.contains(map[blockX][blockY])) {
            map[blockX][blockY].setBuildingLevel(Level.DOME);
            return 0; /* [NOTIFY]: Move successful */
        }
        return -1; /* [NOTIFY]: Move failed */
    }

}
