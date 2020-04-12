package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class BasicReturnSelectOptionsConcrete implements ReturnSelectOptionsStrategy {

    private boolean lookAround(Worker worker, Match match) {
        Cell workersCell = worker.getCurrentPosition();
        int i, j;
        boolean canSelectWorker = false;
        int tempX = worker.getCurrentPosition().getX();
        int tempY = worker.getCurrentPosition().getY();
        int deltaLevel;


        for (i = tempX - 1; i < tempX + 2; i++) {
            for (j = tempY +1; j > tempY - 2; j--) {
                if ((i >= 0 && i < 5) && (j >= 0 && j <5)) {
                    if (match.getMap()[i][j].getWorkerOnCell() == null && match.getMap()[i][j].getBuildingLevel() != Level.DOME) {
                        deltaLevel = (match.getMap()[i][j].getBuildingLevel().ordinal()) - (worker.getCurrentPosition().getBuildingLevel().ordinal());
                        if (deltaLevel < 2) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    @Override
    public List<Cell> doReturnSelectOptions(Match match) {
        Player currPlayer = match.getCurrentTurn().getCurrentPlayer();
        List<Cell> tempCells = new ArrayList();
        int i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner() == currPlayer) {
                    if (lookAround(match.getMap()[i][j].getWorkerOnCell(), match)) {
                        tempCells.add(match.getMap()[i][j]);
                    }
                }
            }
        }

        if(tempCells.size()==0) {
            System.out.println("hai perso per favore chiamiamo la routine che fa finire questo strazio");
        }
    return tempCells;
    }
}
