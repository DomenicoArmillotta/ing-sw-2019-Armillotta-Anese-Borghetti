package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsMovePush extends FindAvailableCellsMove {

    /* Calcola spostamento indicando cosa somare alle cordinate x,y ritorna un array */
    public int calcolaSpostamentoX(Worker selectedWorker, Cell selectedCell) {
        Cell cellaWorkerCheSposta = selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare = selectedCell;
        int differenceX = cellaWorkerCheSposta.getX() - cellaWorkerDaSpostare.getX();
        return differenceX;
    }

    public int calcolaSpostamentoY(Worker selectedWorker, Cell selectedCell) {
        Cell cellaWorkerCheSposta = selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare = selectedCell;
        int differenceY=cellaWorkerCheSposta.getY()-cellaWorkerDaSpostare.getY();
        return differenceY;
    }

    @Override
    public int doAction(int[] userInput) {
        super.doAction(userInput);

        Cell[][] map = super.getExecutorPointer().getMap();

        Worker selectedWorker;
        for (int index = 0; index < 2; index++) {
            if (index == 0) selectedWorker = getExecutorPointer().getCurrentPlayer().getFirstWorker();
            else selectedWorker = getExecutorPointer().getCurrentPlayer().getSecondWorker();
            List<Cell> moveCells = super.getExecutorPointer().getNextMove().getAvailableCells(index);
            List<Cell> addMoveCells = new ArrayList<>();

            int i, j, x, y, check;
            int shiftX;
            int shiftY;

            x = selectedWorker.getCurrentPosition().getX();
            y = selectedWorker.getCurrentPosition().getY();
            for (i = x - 1; i < x + 2 && i < 5; i++) {
                for (j = y - 1; j < y + 2 && j < 5; j++) {
                    check = 1;
                    if (i < 0) i = 0;
                    if (j < 0) j = 0;


                    /* Se  c'è un operatore ed è mio  non  aggiungo nella lista in alternativa lo aggiungo e controllo che nella cella in direzione c'e una cella libera */
                    if (map[i][j].getWorkerOnCell() != null && map[i][j].getWorkerOnCell().getOwner() == selectedWorker.getOwner() && check == 1) {
                        check = 0;
                    } else if (map[i][j].getWorkerOnCell() != null && check == 1 && (selectedWorker.getCurrentPosition().getBuildingLevel().ordinal() - map[i][j].getBuildingLevel().ordinal()) >= -1) {
                        shiftX = calcolaSpostamentoX(selectedWorker, map[i][j]);
                        shiftY = calcolaSpostamentoY(selectedWorker, map[i][j]);
                        /* Se la cella dove si dovrebbe spostare il worker pushato è libera  aggiungo alla lista delle celle */
                        if ((i - shiftX >= 0) && (j - shiftY >= 0) && map[i - shiftX][j - shiftY].getWorkerOnCell() == null) {
                            if (!moveCells.contains(map[i - shiftX][j - shiftY]))
                                addMoveCells.add(map[i][j]);
                        }
                    }

                }
            }
            super.getExecutorPointer().getNextMove().addCells(addMoveCells, index);
        }
        List<Cell> availableCellsPush = new ArrayList<>();
        if(super.getExecutorPointer().getNextMove().getAvailableCells(0).size() != 0) {
            availableCellsPush.add(getExecutorPointer().getCurrentPlayer().getFirstWorker().getCurrentPosition());
        }
        if(super.getExecutorPointer().getNextMove().getAvailableCells(1).size() != 0) {
            availableCellsPush.add(getExecutorPointer().getCurrentPlayer().getSecondWorker().getCurrentPosition());
        }

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(availableCellsPush));
        //getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextMove().getAvailableCells(0)));
        return 0; /* [NOTIFY]: FindAvailableCellsMovePush done */
    }

}
