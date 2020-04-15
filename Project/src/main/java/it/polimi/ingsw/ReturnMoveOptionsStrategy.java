package it.polimi.ingsw;
//devo fare qualcosa di diverso per minotauro e apollo e artemide per controllare la penultima
//la funzione deve ritorare la lista di celle su cui posso spostarmi quindi controllare altezza palazzi ma posso saltare giu,sec'è avversario
//i bordi,cupola,worker mio
//aggiornale nelle godcards i match le strategy

import java.util.List;

public interface ReturnMoveOptionsStrategy {
    public List<Cell> doReturnMoveOptions(Worker selectedWorker);
}
