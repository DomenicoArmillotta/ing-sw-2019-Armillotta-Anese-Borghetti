package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.mvevents.actionevents.BuildBlockEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.NoUpdatesEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

import java.util.List;

/* Forzo costruzione cupola dove si può costruire */
public class InstantBuildDome extends Build {
    @Override
    public int doAction(int[] userInput) {

        Cell[][] map = getExecutorPointer().getMap();
        /* Cella su cui voglio costruire */
        int blockX = userInput[0];
        int blockY = userInput[1];
        int index;
        if (getExecutorPointer().getPrevSelect().getSelectedWorker() == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1;
        List<Cell> availableCells = getAvailableCells(index);
        /*propago le find available cells anche alla build successiva*/
        getExecutorPointer().getNextBuild().setAvailableCells(availableCells,index);

        if(blockY == super.getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition().getY() && blockX == super.getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition().getX()){
            EventsBuffer.instance().setLastEventBean(new NoUpdatesEventBean());
            return 0;
        }
        if (availableCells.contains(map[blockX][blockY])) {
            map[blockX][blockY].setBuildingLevel(Level.DOME);
            getBuildBlockListener().buildBlock(new BuildBlockEvent(map[blockX][blockY]));
            return 1; /* [NOTIFY]: Move successful */
        }
        getFailedActionListener().actionFailed(new FailedActionEvent(this));
        return -1; /* [NOTIFY]: Move failed */
    }

}
