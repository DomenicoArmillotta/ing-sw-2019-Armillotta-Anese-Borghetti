package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSelectMove extends FindAvailableCells {

    public List<Cell> findMoveOptions(Worker selectedWorker) {
        List<Cell> moveCells = new ArrayList<>();
        Cell[][] map = super.getExecutorPointer().getMap();
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker())
            index = 0;
        else
            index = 1;

        int i, j, x, y, check;

        if (selectedWorker == null)
            return null;
        x = selectedWorker.getCurrentPosition().getX();
        y = selectedWorker.getCurrentPosition().getY();
        //aggiungere condizione del bordo inferiore
        //System.out.print("Celle calcolate == ");

        for (i = x - 1; i < x + 2 && i < 5; i++) {
            for (j = y - 1; j < y + 2 && j < 5; j++) {
                check = 1;
                if (i < 0) i = 0;
                if (j < 0) j = 0;
                //se  c'è un worker sopra non  aggiungo nella lista
                if (map[i][j].getWorkerOnCell() != null && check == 1) {
                    check = 0;
                }
                //se  c'è una cupola non  aggiungo nella lista
                if (map[i][j].getBuildingLevel() == Level.DOME && check == 1) {
                    check = 0;

                }
                //se la differenza è maggiore di 1 non aggiungo nella lista
                if ((selectedWorker.getCurrentPosition().getBuildingLevel().ordinal() - map[i][j].getBuildingLevel().ordinal()) < -1 && check == 1) {

                    check = 0;

                }
                if (check == 1) {
                    //inserisce nella lista
                    moveCells.add(map[i][j]);

                }
            }
        }
        getExecutorPointer().getNextMove().setAvailableCells(moveCells, index);

        return moveCells;

    }

    @Override
    public int doAction(int[] userInput) {
        Worker firstWorker = getExecutorPointer().getCurrentPlayer().getFirstWorker();
        Worker secondWorker = getExecutorPointer().getCurrentPlayer().getSecondWorker();
        findMoveOptions(firstWorker);
        findMoveOptions(secondWorker);
        return 0;
    }
}
