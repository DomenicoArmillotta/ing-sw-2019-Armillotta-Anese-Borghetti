package it.polimi.ingsw;

public class BasicMoveConcrete implements MoveWorkerStrategy{
    @Override
    //devo spostare il worker delegando il controllo al controller(che deve coontrollare altezza edificio e se ci sono altri worker)
    public void moveWorker(Worker selectedWorker, Cell selectedCells) {
            selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
            selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
            selectedCells.setWorkerOnCell(selectedWorker);
            selectedWorker.setCurrentPosition(selectedCells);
            selectedWorker.setCurrentLevel(selectedCells.getBuildingLevel());
    }
}
