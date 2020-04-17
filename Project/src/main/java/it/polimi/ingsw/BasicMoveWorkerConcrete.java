package it.polimi.ingsw;

public class BasicMoveWorkerConcrete implements MoveWorkerStrategy {
    @Override
    //devo spostare il worker delegando il controllo al controller(che deve coontrollare altezza edificio e se ci sono altri worker)
    public void doMoveWorker(Worker selectedWorker, Cell selectedCell) {
        selectedWorker.getCurrentPosition().setWorkerOnCell(null);
        selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
        selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
        selectedCell.setWorkerOnCell(selectedWorker);
        selectedWorker.setCurrentPosition(selectedCell);
        selectedWorker.setCurrentLevel(selectedCell.getBuildingLevel());
    }
}
