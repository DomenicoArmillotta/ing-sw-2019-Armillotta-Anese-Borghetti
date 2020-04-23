package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSelectPush extends FindAvailableCellsSelect {
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        List<Cell> availableCells = super.getExecutorPointer().getNextSelect().getAvailableCells();
        List<Worker> pushableWorker = new ArrayList<>();
        List<Cell> tempcells = new ArrayList<>();


        int i, j;
        boolean addable = false;
        int tempX = 0;
        int tempY = 0;
        int h = 0;

        pushableWorker.add(super.getExecutorPointer().getCurrentPlayer().getFirstWorker());
        pushableWorker.add(super.getExecutorPointer().getCurrentPlayer().getSecondWorker());
        /*

        note to-self

        (match.getMap()[i][j].getWorkerOnCell() == null || wo
                            }
                        }
                    }
                }

            }
            return 0;rker.getOwner()!=match.getMap()[i][j].getWorkerOnCell().getOwner()
        serve per evitare segfault ,in pratica se c'è un worker allora guardo il suo owner
        viceversa se NON c'è un worker NON faccio questo Controllo.


        //posso dividere il controllo in 2 parti, la prima controlla i dome s e deltaheights
        //la seconda se la prima risulta falsa controlla che ci siano workers e siano pushabili;
        */
        super.doAction(userInput);
        while (pushableWorker.size() > h) {
            for (i = tempX - 1; i < tempX + 2 && !addable; i++) {
                for (j = tempY + 1; j > tempY - 2 && !addable; j--) {
                    if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                        if (super.getExecutorPointer().getMap()[i][j].getWorkerOnCell() != null && !pushableWorker.contains(super.getExecutorPointer().getMap()[i][j].getWorkerOnCell())) {
                            if (super.getExecutorPointer().getMap()[i][j].getBuildingLevel().ordinal() - (pushableWorker.get(h).getCurrentPosition().getBuildingLevel().ordinal()) <= 1) {
                                //se c'è un worker che non è mio e che si può pushare;
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
                addable = false;
            }
            h++;
        }
        super.getExecutorPointer().getNextSelect().setAvailableCells(tempcells);
        if(tempcells.size()==0)
            return -1;
        else
            return 0;
    }
}

