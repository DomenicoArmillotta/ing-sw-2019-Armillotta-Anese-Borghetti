package it.polimi.ingsw;

public class MoveSwitchingWorkersConcrete implements MoveWorkerStrategy {
    @Override
    //scambia i personaggi
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
        selectedWorker.getPreviousPosition().setWorkerOnCell(temporaryCell.getWorkerOnCell());

        selectedWorker.setCurrentPosition(selectedCells);
        selectedWorker.getPreviousPosition().getWorkerOnCell().setCurrentPosition(selectedWorker.getPreviousPosition());


    }
}
