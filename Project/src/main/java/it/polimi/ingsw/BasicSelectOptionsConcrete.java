package it.polimi.ingsw;

public class BasicSelectOptionsConcrete implements SelectOptionsStrategy {
    @Override
    public Worker select(Turn turn) {
        //allora il controller mi passa tutte le cose gia paraste e io devo solo;
        //digerirle;
        //some input mi aspetto che ciò che passa sia == a quello che il model;
        //ha in serbo;
        int i=0,j=0;

        return turn.getMatch().getMap()[i][j].getWorkerOnCell();
    }
}
