package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;

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
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 0;
        } else {
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1;
        }
    }

}
