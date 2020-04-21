package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.List;
public class FindAvailableCellsPushSelect extends FindAvailableCellsSelect {
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        List<Cell> tempCells = super.getExecutorPointer().getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();
        int i, j;
        boolean addable = false;
        int tempX = 0;
        int tempY = 0;
        int h = 0;
        int deltaLevel = 0;
        return 0;
    }
}
        /*

        note to-self

        (match.getMap()[i][j].getWorkerOnCell() == null || worker.getOwner()!=match.getMap()[i][j].getWorkerOnCell().getOwner()
        serve per evitare segfault ,in pratica se c'è un worker allora guardo il suo owner
        viceversa se NON c'è un worker NON faccio questo Controllo.


        //posso dividere il controllo in 2 parti, la prima controlla i dome s e deltaheights
        //la seconda se la prima risulta falsa controlla che ci siano workers e siano pushabili;
        while (tempCells.size() < h) {
            for (i = tempX - 1; i < tempX + 2 && addable==false; i++) {
                for (j = tempY + 1; j > tempY - 2 && addable == false; j--) {
                    if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                        if (super.getExecutorPointer().getMap()[i][j].getWorkerOnCell() == null || !tempCells.contains(super.getExecutorPointer().getMap()[i][j].getWorkerOnCell())) {
                                deltaLevel = (super.getExecutorPointer().getMap()[i][j].getBuildingLevel().ordinal()) - (tempCells.get(h).getBuildingLevel().ordinal());
                                if (deltaLevel < 2) {
                                    addable=true;
                                }
                            } else {//allora c'è un worker
                                deltaLevel = (super.getExecutorPointer().getMap()[i][j].getBuildingLevel().ordinal()) - (tempCells.get(h).getBuildingLevel().ordinal());
                                if (deltaLevel < 2) {
                                    tempX = super.getExecutorPointer().getMap()[i][j].getX() - tempCells.get(h).getX();
                                    tempY = super.getExecutorPointer().getMap()[i][j].getY() - tempCells.get(h).getY();

                                    tempX = super.getExecutorPointer().getMap()[i][j].getX() + tempX;
                                    tempY = super.getExecutorPointer().getMap()[i][j].getY() + tempY;
                                    if (((tempX >= 0 && tempX < 5) && (tempY >= 0 && tempY < 5)) && super.getExecutorPointer().getMap()[tempX][tempY].getWorkerOnCell() == null)
                                        return true;
                                }
                            }
                        }
                    }
                }

            }
            return false;
        }
    }
}
*/