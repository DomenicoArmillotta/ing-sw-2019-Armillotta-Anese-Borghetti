package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSelectPush extends FindAvailableCellsSelect {
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        List<Cell> availableCells = super.getExecutorPointer().getNextSelect().getAvailableCells(0);
        List<Worker> pushableWorker = new ArrayList<>();
        List<Cell> tempcells = new ArrayList<>();


        int i, j;
        boolean addable = false;
        int tempX = 0;
        int tempY = 0;
        int h = 0;

        pushableWorker.add(super.getExecutorPointer().getCurrentPlayer().getFirstWorker());
        pushableWorker.add(super.getExecutorPointer().getCurrentPlayer().getSecondWorker());

        while (pushableWorker.size() > h) {
            tempX = pushableWorker.get(h).getCurrentPosition().getX();
            tempY = pushableWorker.get(h).getCurrentPosition().getY();
            for (i = tempX - 1; i < tempX + 2 && !addable; i++) {
                for (j = tempY + 1; j > tempY - 2 && !addable; j--) {
                    if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                        if (super.getExecutorPointer().getMap()[i][j].getWorkerOnCell() != null && !pushableWorker.contains(super.getExecutorPointer().getMap()[i][j].getWorkerOnCell())) {
                            if (super.getExecutorPointer().getMap()[i][j].getBuildingLevel().ordinal() - (pushableWorker.get(h).getCurrentPosition().getBuildingLevel().ordinal()) <= 1) {
                                //se c'è un worker che non è mio e che si può pushare;
                                System.out.println();
                                tempX = super.getExecutorPointer().getMap()[i][j].getX() - pushableWorker.get(h).getCurrentPosition().getX();
                                tempY = super.getExecutorPointer().getMap()[i][j].getY() - pushableWorker.get(h).getCurrentPosition().getY();

                                tempX = super.getExecutorPointer().getMap()[i][j].getX() + tempX;
                                tempY = super.getExecutorPointer().getMap()[i][j].getY() + tempY;
                                if (((tempX >= 0 && tempX < 5) && (tempY >= 0 && tempY < 5)) && super.getExecutorPointer().getMap()[tempX][tempY].getWorkerOnCell() == null) {
                                    addable = true;
                                }
                            }
                        }
                    }
                }
            }
            if (addable) {
                tempcells.add(pushableWorker.get(h).getCurrentPosition());
                if (!super.getExecutorPointer().getNextSelect().getAvailableCells(0).contains(pushableWorker.get(h))) {
                    //se non contiene la cella allora deve essere aggiunta manualmente
                    super.getExecutorPointer().getNextSelect().getAvailableCells(0).add(pushableWorker.get(h).getCurrentPosition());
                }
                addable = false;
            }
            h++;
        }
        if (super.getExecutorPointer().getNextSelect().getAvailableCells(0).isEmpty()) {
            System.out.println("routine di perdita");
            return 0;
        } else
            return 0;
    }
}

