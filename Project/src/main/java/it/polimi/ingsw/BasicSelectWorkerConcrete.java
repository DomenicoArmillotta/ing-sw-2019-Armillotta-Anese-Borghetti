package it.polimi.ingsw;

public class BasicSelectWorkerConcrete implements SelectWorkerStrategy {
    @Override
    public Worker doSelectWorker(Cell selectedCell) {
        //allora il controller mi passa tutte le cose gia paraste e io devo solo;
        //digerirle;
        //some input mi aspetto che ciò che passa sia == a quello che il model;
        //ha in serbo;
        return selectedCell.getWorkerOnCell();
    }
}
