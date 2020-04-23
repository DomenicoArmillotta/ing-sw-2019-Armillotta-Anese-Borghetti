package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Level;

import java.util.List;
//se non è cupola va normalmente,altrimenti ritorno -1
public class DontBuildDome extends Build {
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = getAvailableCells();
        Cell[][] map = getExecutorPointer().getMap();
        //cella su cui voglio costruire
        int blockX = userInput[0];
        int blockY = userInput[1];
        if (map[blockX][blockY].getBuildingLevel().getNext()!=Level.DOME) {
            super.doAction(userInput);
            return 0;
        }else{
            return -1;

        }

    }

}
