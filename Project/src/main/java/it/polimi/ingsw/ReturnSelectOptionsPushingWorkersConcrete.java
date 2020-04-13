package it.polimi.ingsw;

/*
MINOTAURO
 */

import java.util.ArrayList;
import java.util.List;

public class ReturnSelectOptionsPushingWorkersConcrete implements ReturnSelectOptionsStrategy{

    private boolean lookAround(Worker worker, Match match) {
        List<Worker> pushableWorkers = new ArrayList();
        int i, j;
        boolean nextControl = false;
        int tempX = worker.getCurrentPosition().getX();
        int tempY = worker.getCurrentPosition().getY();
        int deltaLevel;

        /*

        note to-self

        (match.getMap()[i][j].getWorkerOnCell() == null || worker.getOwner()!=match.getMap()[i][j].getWorkerOnCell().getOwner()
        serve per evitare segfault ,in pratica se c'è un worker allora guardo il suo owner
        viceversa se NON c'è un worker NON faccio questo Controllo.
         */

        //posso dividere il controllo in 2 parti, la prima controlla i dome s e deltaheights
        //la seconda se la prima risulta falsa controlla che ci siano workers e siano pushabili;
            for (i = tempX - 1; i < tempX + 2; i++) {
                for (j = tempY +1; j > tempY - 2; j--) {
                    if((i >= 0 && i < 5) && (j >= 0 && j <5)) {
                        if(match.getMap()[i][j].getBuildingLevel() != Level.DOME){
                            if(match.getMap()[i][j].getWorkerOnCell()==null){
                                deltaLevel = (match.getMap()[i][j].getBuildingLevel().ordinal()) - (worker.getCurrentPosition().getBuildingLevel().ordinal());
                                if (deltaLevel < 2) {
                                    return true;
                                }
                            }else{//allora c'è un worker
                                deltaLevel = (match.getMap()[i][j].getBuildingLevel().ordinal()) - (worker.getCurrentPosition().getBuildingLevel().ordinal());
                                if(deltaLevel<2){
                                      tempX=match.getMap()[i][j].getX()-worker.getCurrentPosition().getX();
                                      tempY=match.getMap()[i][j].getY()-worker.getCurrentPosition().getY();

                                      tempX=match.getMap()[i][j].getX()+tempX;
                                      tempY=match.getMap()[i][j].getY()+tempY;
                                      if(((tempX>=0 && tempX<5) &&  (tempY>=0 && tempY<5)) && match.getMap()[tempX][tempY].getWorkerOnCell()==null)
                                          return true;
                                }
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
