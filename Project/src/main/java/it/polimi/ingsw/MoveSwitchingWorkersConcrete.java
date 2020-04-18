package it.polimi.ingsw;

public class MoveSwitchingWorkersConcrete implements MoveWorkerStrategy {
    @Override
    //scambia i personaggi
    public void doMoveWorker(Worker selectedWorker, Cell selectedCells) {
        selectedWorker.getCurrentPosition().setWorkerOnCell(null);
        Cell temporaryCell = new Cell();
        Worker workerDaSpostare = selectedCells.getWorkerOnCell();
        selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
        selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
        selectedCells.getWorkerOnCell().setPreviousLevel(workerDaSpostare.getCurrentLevel());
        selectedCells.getWorkerOnCell().setPreviousPosition(workerDaSpostare.getCurrentPosition());

        //creo cella metto quello che viene spostato in questa cella di standby e poi lo sposto
        //temporaryCell.setWorkerOnCell(workerDaSpostare);
        selectedCells.setWorkerOnCell(selectedWorker);
        //rimetto worker spostato a terra
        selectedWorker.getPreviousPosition().setWorkerOnCell(workerDaSpostare);

        workerDaSpostare.setCurrentPosition(selectedWorker.getPreviousPosition());
        selectedWorker.setCurrentPosition(selectedCells);


    }
}
