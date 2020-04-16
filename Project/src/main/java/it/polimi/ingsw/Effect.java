package it.polimi.ingsw;

import java.util.*;

public class Effect {
    private GodCard associatedCard;
    private boolean isActive;
    private ReturnSelectOptionsStrategy returnSelectOptions;
    private SubtractSelectRestraintsStrategy subtractSelectRestraints;
    private SelectWorkerStrategy selectWorker;
    private ReturnBuildOptionsStrategy returnBuildOptionsBeforeMove;
    private BuildBlockStrategy buildBlockBeforeMove;
    private ReturnMoveOptionsStrategy returnFirstMoveOptions;
    private SubtractMoveRestraintsStrategy subtractFirstRestraints;
    private MoveWorkerStrategy moveWorkerFirstTime;
    private ReturnMoveOptionsStrategy returnSecondMoveOptions;
    private SubtractMoveRestraintsStrategy subtractSecondRestraints;
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

    public void changeSubtractMoveRestraintsStrategy(SubtractSelectRestraintsStrategy newSubtractRestraintsSelectConcrete, SubtractMoveRestraintsStrategy newSubtractRestraintsMoveConcrete) {
        this.subtractSelectRestraints = newSubtractRestraintsSelectConcrete;
        this.subtractFirstRestraints = newSubtractRestraintsMoveConcrete;
        this.subtractSecondRestraints = newSubtractRestraintsMoveConcrete;
    }

    public List<Cell> doReturnSelectOptions(Match currentMatch) {
        return this.returnSelectOptions.doReturnSelectOptions(currentMatch);
    }

    public List<Cell> doSubtractSelectRestraints(List<Cell> selectOptionsCells) {
        return this.subtractSelectRestraints.doSubtractSelectRestraints(selectOptionsCells);
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

    public List<Cell> doSubtractFirstRestraints(List<Cell> moveOptionsCells, Worker selectedWorker) {
        return this.subtractFirstRestraints.doSubtractMoveRestraints(moveOptionsCells, selectedWorker);
    }

    public void doMoveWorkerFirstTime(Worker selectedWorker, Cell selectedCell) {
        this.moveWorkerFirstTime.doMoveWorker(selectedWorker, selectedCell);
    }

    public List<Cell> doReturnSecondMoveOptions(Worker selectedWorker) {
        return this.returnSecondMoveOptions.doReturnMoveOptions(selectedWorker);
    }

    public List<Cell> doSubtractSecondRestraints(List<Cell> moveOptionsCells, Worker selectedWorker) {
        return this.subtractSecondRestraints.doSubtractMoveRestraints(moveOptionsCells, selectedWorker);
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

    public void setEffectStrategies(ReturnSelectOptionsStrategy returnSelectOptions, SubtractSelectRestraintsStrategy subtractSelectRestraints, SelectWorkerStrategy selectWorker,
                                    ReturnBuildOptionsStrategy returnBuildOptionsBeforeMove, BuildBlockStrategy buildBlockBeforeMove,
                                    ReturnMoveOptionsStrategy returnFirstMoveOptions, SubtractMoveRestraintsStrategy subtractFirstRestraints,
                                    MoveWorkerStrategy moveWorkerFirstTime, ReturnMoveOptionsStrategy returnSecondMoveOptions,
                                    SubtractMoveRestraintsStrategy subtractSecondRestraints, MoveWorkerStrategy moveWorkerSecondTime,
                                    ReturnBuildOptionsStrategy returnFirstBuildOptionsAfterMove, BuildBlockStrategy buildFirstBlockAfterMove,
                                    ReturnBuildOptionsStrategy returnSecondBuildOptionsAfterMove, BuildBlockStrategy buildSecondBlockAfterMove) {
        this.returnSelectOptions = returnSelectOptions;
        this.subtractSelectRestraints = subtractSelectRestraints;
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
