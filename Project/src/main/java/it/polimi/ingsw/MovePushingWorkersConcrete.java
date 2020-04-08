package it.polimi.ingsw;

public class MovePushingWorkersConcrete implements MoveWorkerStrategy {

    /* aggiungere controllo che la cella adiacente sia libera */

    public Worker WorkerSpostato(Cell selectedCells) {
        return selectedCells.getWorkerOnCell();
    }

    //calcola spostamento indicando cosa somare alle cordinate x,y ritorna un array
    public int calcolaSpostamentoX(Worker selectedWorker, Cell selectedCell) {
        Cell cellaWorkerCheSposta = selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare = selectedCell;
        int differenceX = cellaWorkerCheSposta.getX() - cellaWorkerDaSpostare.getX();
        return differenceX;
    }
    public int calcolaSpostamentoY(Worker selectedWorker,Cell selectedCell){
        Cell cellaWorkerCheSposta=selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare=selectedCell;
        int differenceY=cellaWorkerCheSposta.getY()-cellaWorkerDaSpostare.getY();
        return differenceY;
    }
    public Cell sposta(Cell cellaDaSpostare,int X,int Y){
        cellaDaSpostare.setX(cellaDaSpostare.getX()+X);
        cellaDaSpostare.setY(cellaDaSpostare.getY()+Y);
        return cellaDaSpostare;
    }
    @Override
    public void moveWorker(Worker selectedWorker, Cell selectedCells, Turn turn) {

        Cell temporaryCell = new Cell();
        Worker workerDaSpostare=selectedCells.getWorkerOnCell();
        selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
        selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
        workerDaSpostare.setPreviousLevel(workerDaSpostare.getCurrentLevel());
        workerDaSpostare.setPreviousPosition(workerDaSpostare.getCurrentPosition());

        //creo cella metto quello che viene spostato in questa cella di standby e poi lo sposto
        temporaryCell.setWorkerOnCell(workerDaSpostare);
        selectedCells.setWorkerOnCell(selectedWorker);
        //rimetto worker spostato a terra
        Cell newCellWithPush;
        newCellWithPush=sposta(selectedWorker.getPreviousPosition(),calcolaSpostamentoX(selectedWorker,selectedCells),calcolaSpostamentoY(selectedWorker,selectedCells));
        newCellWithPush.setWorkerOnCell(temporaryCell.getWorkerOnCell());

        selectedWorker.setCurrentPosition(selectedCells);
        workerDaSpostare.setCurrentPosition(newCellWithPush);

    }
}
