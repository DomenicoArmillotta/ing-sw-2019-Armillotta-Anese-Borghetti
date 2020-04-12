package it.polimi.ingsw;

import java.util.*;

public class Effect {
    private GodCard associatedCard;
    private boolean isActive;
    private ReturnSelectOptionsStrategy returnSelectOptions;
    private SelectWorkerStrategy selectWorker;
    private ReturnBuildOptionsStrategy returnBuildOptionsBeforeMove;
    private BuildBlockStrategy buildBlockBeforeMove;
    private ReturnMoveOptionsStrategy returnFirstMoveOptions;
    private SubtractRestraintsStrategy subtractFirstRestraints;
    private MoveWorkerStrategy moveWorkerFirstTime;
    private ReturnMoveOptionsStrategy returnSecondMoveOptions;
    private SubtractRestraintsStrategy subtractSecondRestraints;
    private MoveWorkerStrategy moveWorkerSecondTime;
    private ReturnBuildOptionsStrategy returnFirstBuildOptionsAfterMove;
    private BuildBlockStrategy buildFirstBlockAfterMove;
    private ReturnBuildOptionsStrategy returnSecondBuildOptionsAfterMove;
    private BuildBlockStrategy buildSecondBlockAfterMove;

    public void setStatus(boolean newStatus) {
        this.isActive = newStatus;
    }

    public boolean getStatus() {
        return isActive;
    }

    public Cell[][] getMap() {
        return associatedCard.getOwner().getCurrentMatch().getMap();
    }

    public List<Cell> doReturnSelectOptions(Match currentMatch) {
        return this.returnSelectOptions.doReturnSelectOptions(currentMatch);
    }

    public Worker doSelectWorker(Cell selectedCell) {
        return this.selectWorker.doSelectWorker(selectedCell);
    }

    public List<Cell> doReturnBuildOptionsBeforeMove(Worker selectedWorker) {
        return this.returnBuildOptionsBeforeMove.doReturnBuildOptions(selectedWorker);
    }

    public void doBuildBlockBeforeMove(Cell selectedCell) {
        this.buildBlockBeforeMove.doBuildBlock(selectedCell);
    }

    public List<Cell> doReturnFirstMoveOptions(Worker selectedWorker) {
        return this.returnFirstMoveOptions.doReturnMoveOptions(selectedWorker);
    }

    public List<Cell> doSubtractFirstRestraints(List<Cell> moveOptionsCells) {
        return this.subtractFirstRestraints.doSubtractRestraints(moveOptionsCells);
    }

    public void doMoveWorkerFirstTime(Worker selectedWorker, Cell selectedCell) {
        this.moveWorkerFirstTime.doMoveWorker(selectedWorker, selectedCell);
    }

    public List<Cell> doReturnSecondMoveOptions(Worker selectedWorker) {
        return this.returnSecondMoveOptions.doReturnMoveOptions(selectedWorker);
    }

    public List<Cell> doSubtractSecondRestraints(List<Cell> moveOptionsCells) {
        return this.subtractSecondRestraints.doSubtractRestraints(moveOptionsCells);
    }

    public void doMoveWorkerSecondTime(Worker selectedWorker, Cell selectedCell) {
        this.moveWorkerSecondTime.doMoveWorker(selectedWorker, selectedCell);
    }

    public List<Cell> doReturnFirstBuildOptionsAfterMove(Worker selectedWorker) {
        return this.returnFirstBuildOptionsAfterMove.doReturnBuildOptions(selectedWorker);
    }

    public void doBuildFirstBlockAfterMove(Cell selectedCell) {
        this.buildFirstBlockAfterMove.doBuildBlock(selectedCell);
    }

    public List<Cell> doReturnSecondBuildOptionsAfterMove(Worker selectedWorker) {
        return this.returnSecondBuildOptionsAfterMove.doReturnBuildOptions(selectedWorker);
    }

    public void doBuildSecondBlockAfterMove(Cell selectedCell) {
        this.buildSecondBlockAfterMove.doBuildBlock(selectedCell);
    }

    public GodCard getAssociatedCard() {
        return associatedCard;
    }

    public GodCard getPrevPlayerGod() {
        return this.getAssociatedCard().getOwner().getCurrentMatch().getCurrentTurn().getPrevPlayer().getPlayerGod();
    }

    public GodCard getNextPlayerGod() {
        return this.getAssociatedCard().getOwner().getCurrentMatch().getCurrentTurn().getNextPlayer().getPlayerGod();
    }

    public void setEffectStrategies(ReturnSelectOptionsStrategy returnSelectOptions, SelectWorkerStrategy selectWorker,
                                    ReturnBuildOptionsStrategy returnBuildOptionsBeforeMove, BuildBlockStrategy buildBlockBeforeMove,
                                    ReturnMoveOptionsStrategy returnFirstMoveOptions, SubtractRestraintsStrategy subtractFirstRestraints,
                                    MoveWorkerStrategy moveWorkerFirstTime, ReturnMoveOptionsStrategy returnSecondMoveOptions,
                                    SubtractRestraintsStrategy subtractSecondRestraints, MoveWorkerStrategy moveWorkerSecondTime,
                                    ReturnBuildOptionsStrategy returnFirstBuildOptionsAfterMove, BuildBlockStrategy buildFirstBlockAfterMove,
                                    ReturnBuildOptionsStrategy returnSecondBuildOptionsAfterMove, BuildBlockStrategy buildSecondBlockAfterMove) {
        this.returnSelectOptions = returnSelectOptions;
        this.selectWorker = selectWorker;
        this.returnBuildOptionsBeforeMove = returnBuildOptionsBeforeMove;
        this.buildBlockBeforeMove = buildBlockBeforeMove;
        this.returnFirstMoveOptions = returnFirstMoveOptions;
        this.subtractFirstRestraints = subtractFirstRestraints;
        this.moveWorkerFirstTime = moveWorkerFirstTime;
        this.returnSecondMoveOptions = returnSecondMoveOptions;
        this.subtractSecondRestraints = subtractSecondRestraints;
        this.moveWorkerSecondTime = moveWorkerSecondTime;
        this.returnFirstBuildOptionsAfterMove = returnFirstBuildOptionsAfterMove;
        this.buildFirstBlockAfterMove = buildFirstBlockAfterMove;
        this.returnSecondBuildOptionsAfterMove = returnSecondBuildOptionsAfterMove;
        this.buildSecondBlockAfterMove = buildSecondBlockAfterMove;
    }

}
