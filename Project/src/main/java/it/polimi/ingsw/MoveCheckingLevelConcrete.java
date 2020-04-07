package it.polimi.ingsw;

public class MoveCheckingLevelConcrete implements MoveWorkerStrategy {
    @Override
    public void moveWorker(Worker selectedWorker, Cell selectedCells, Turn turn) {
        selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
        selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
        selectedCells.setWorkerOnCell(selectedWorker);
        selectedWorker.setCurrentPosition(selectedCells);
        selectedWorker.setCurrentLevel(selectedCells.getBuildingLevel());
        if(selectedWorker.getPreviousLevel().ordinal()-selectedWorker.getCurrentLevel().ordinal()>0) {
            selectedWorker.getOwner().getPlayerGod().getEffect().setIsActive(true);
        }

    }

}
