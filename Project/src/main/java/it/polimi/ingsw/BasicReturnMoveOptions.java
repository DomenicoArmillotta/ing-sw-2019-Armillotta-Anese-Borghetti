package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;
//devo fare qualcosa di diverso per minotauro e apollo e artemide per controllare la penultima
//la funzione deve ritorare la lista di celle su cui posso spostarmi quindi controllare altezza palazzi ma posso saltare giu,sec'è avversario
//i bordi,cupola,worker mio
//aggiornale nelle godcards i match le strategy
public class BasicReturnMoveOptions implements ReturnMoveOptionsStrategy {
    @Override
    public List<Cell> doReturnMoveOptions(Worker selectedWorker) {
        //ciclo
        int i, j, x, y, check;

        List<Cell> MoveCells = new ArrayList();
        x = selectedWorker.getCurrentPosition().getX();
        y = selectedWorker.getCurrentPosition().getY();
        Match currentMatch = selectedWorker.getOwner().getCurrentMatch();
        //aggiungere condizione del bordo inferiore

        for (i = x - 1; i < x + 2 && i < 5; i++) {
            for (j = y - 1; j < y + 2 && j < 5; j++) {
                check = 1;
                if (i < 0) i = 0;
                if (j < 0) j = 0;
                //se  c'è un operatore sopra non  aggiungo nella lista
                if (currentMatch.getMap()[i][j].getWorkerOnCell() != null && check == 1) {
                    check = 0;
                }
                //se  c'è una cupola non  aggiungo nella lista
                if (currentMatch.getMap()[i][j].getBuildingLevel() == Level.DOME && check == 1) {
                    check = 0;

                }
                //se la differenza è maggiore di 1 non aggiungo nella lista
                if((currentMatch.getMap()[i][j].getBuildingLevel().ordinal()-selectedWorker.getCurrentLevel().ordinal())>1 && check==1 ){

                    check=0;

                }
                if(check==1){
                    //inserisce nella lista
                    MoveCells.add(currentMatch.getMap()[i][j]);
                }
            }
        }
        return MoveCells;
    }
}
