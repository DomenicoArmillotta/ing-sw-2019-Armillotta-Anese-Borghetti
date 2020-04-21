package it.polimi.ingsw;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsMovePush extends FindAvailableCellsMove {
    //calcola spostamento indicando cosa somare alle cordinate x,y ritorna un array
    public int calcolaSpostamentoX(Worker selectedWorker, Cell selectedCell) {
        Cell cellaWorkerCheSposta = selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare = selectedCell;
        int differenceX = cellaWorkerCheSposta.getX() - cellaWorkerDaSpostare.getX();
        return differenceX;
    }

    public int calcolaSpostamentoY(Worker selectedWorker, Cell selectedCell) {
        Cell cellaWorkerCheSposta=selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare=selectedCell;
        int differenceY=cellaWorkerCheSposta.getY()-cellaWorkerDaSpostare.getY();
        return differenceY;
    }

    public int doAction(int[] userInput) {
        Cell[][] map= super.getExecutorPointer().getMap();
        List<Cell> moveCells= super.getExecutorPointer().getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();
        Worker selectedWorker=super.getSelectedWorker();

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
                //se  c'è un operatore ed è mio  non  aggiungo nella lista in alternativa lo aggiungo e controllo che nella cella in direzione c'e una cella libera
                if (map[i][j].getWorkerOnCell() != null && map[i][j].getWorkerOnCell().getOwner() == selectedWorker.getOwner() && check == 1) {
                    check = 0;
                } else if (map[i][j].getWorkerOnCell() != null && check == 1) {
                    shiftX = calcolaSpostamentoX(selectedWorker, map[i][j]);
                    shiftY = calcolaSpostamentoY(selectedWorker, map[i][j]);
                    //se la cella dove si dovrebbe spostare il worker pushato è libera  aggiungo alla lista delle celle
                    if (map[i - shiftX][j - shiftY].getWorkerOnCell() == null) {
                        moveCells.add(map[i][j]);
                    }
                }

            }
        }
        super.getExecutorPointer().getCurrentActualTurn().getSelectMoveList().get(0).setAvailableCells(moveCells);
        return 0;

    }
}