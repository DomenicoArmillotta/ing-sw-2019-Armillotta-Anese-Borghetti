package it.polimi.ingsw;
//se la differenza dei livelli è maggiore di uno attiva is active
public class MoveCheckingLevelConcrete implements MoveWorkerStrategy {
    @Override
    public void doMoveWorker(Worker selectedWorker, Cell selectedCell) {
        selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
        selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
        selectedCell.setWorkerOnCell(selectedWorker);
        selectedWorker.setCurrentPosition(selectedCell);
        selectedWorker.setCurrentLevel(selectedCell.getBuildingLevel());
        if (selectedWorker.getPreviousLevel().ordinal() - selectedWorker.getCurrentLevel().ordinal() > 0) {
            selectedWorker.getOwner().getPlayerGod().getEffect().setStatus(true);
            selectedWorker.getOwner().getCurrentMatch().getCurrentTurn().getNextPlayer().getPlayerGod().getEffect().changeSubtractMoveRestraintsStrategy(new SelectRestraintsDontMoveUpConcrete(), new NoSubtractMoveRestraintsConcrete());
            selectedWorker.getOwner().getCurrentMatch().getCurrentTurn().getPrevPlayer().getPlayerGod().getEffect().changeSubtractMoveRestraintsStrategy(new SelectRestraintsDontMoveUpConcrete(), new NoSubtractMoveRestraintsConcrete());
        }

    }

}
