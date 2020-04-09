package it.polimi.ingsw;

public class BasicSelectOptionsConcrete implements SelectOptionsStrategy {
    @Override
    public Worker select(Turn turn,int inputX,int inputY) {
        //allora il controller mi passa tutte le cose gia paraste e io devo solo;
        //digerirle;
        //some input mi aspetto che ciò che passa sia == a quello che il model;
        //ha in serbo;
        return turn.getMatch().getMap()[inputX][inputY].getWorkerOnCell();
    }
}
