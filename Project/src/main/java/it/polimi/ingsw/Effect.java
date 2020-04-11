package it.polimi.ingsw;

import java.util.*;

/*
TO DO LIST

Interfaccia 1. Cell[2] doShowSelectOptions(Match); Matteo
Interfaccia 2. Worker doSelectWorker(Cell); Matteo
3. Cell[*] doShowBuildOptions(Worker); Marco
4. Void doPossibleBuildBeforeMove(Cell); Marco
Interfaccia 5. Cell[*] doShowMoveOptions(Worker); Matteo
Interfaccia 6. Cell[*] doSubstractRestraints(Worker, Cell[*]); Matteo
Interfaccia 7. Void doMoveWorker(Worker, Cell); Domenico
8. Cell[*] doShowMoveOptions(Worker); Matteo
9. Cell[*] doSubstractRestraints(Worker, Cell[*]); Matteo
10. Void doPossibleSecondMove(Worker, Cell); Domenico
Interfaccia 11. Cell[*] doShowBuildOptions(Worker); Marco
Interfaccia 12. Void doBuildBlock(Cell); Marco
13. Cell[*] doShowBuildOptions(Worker); Marco
14. Void doPossibleSecondBuildBlock(Cell); Marco

 */

public class Effect {
    private GodCard associatedCard;
    private ShowSelectOptionsStrategy showSelectOptions;
    private SelectOptionsStrategy selectOptions;
    private RestraintsCellsStrategy restraintsCells;
    private MoveWorkerStrategy moveWorker;
    private WinCheckStrategy winCheck;
    private ShowBuildOptionsStrategy showBuildOptions;
    private BuildBlockStrategy buildBlock;
    private PossibleSecondMoveStrategy possibleSecondMove;
    private boolean isActive;

    public GodCard getAssociatedCard() {
        return associatedCard;
    }
    public GodCard getPrevPlayerGod(){
        return this.getAssociatedCard().getOwner().getCurrentMatch().getCurrentTurn().getPrevPlayer().getPlayerGod();
    }
    public GodCard getNextPlayerGod(){
        return this.getAssociatedCard().getOwner().getCurrentMatch().getCurrentTurn().getNextPlayer().getPlayerGod();
    }

    public void setEffectStrategies(ShowSelectOptionsStrategy showSelectOptions, SelectOptionsStrategy selectOptions, RestraintsCellsStrategy restraintsCells,
                                    MoveWorkerStrategy moveWorker, WinCheckStrategy winCheck,
                                    PossibleSecondMoveStrategy possibleSecondMove, ShowBuildOptionsStrategy showBuildOptions, BuildBlockStrategy buildBlock) {
        this.showSelectOptions = showSelectOptions;
        this.selectOptions = selectOptions;
        this.restraintsCells = restraintsCells;
        this.moveWorker = moveWorker;
        this.winCheck = winCheck;
        this.possibleSecondMove = possibleSecondMove;
        this.showBuildOptions = showBuildOptions;
        this.buildBlock = buildBlock;
    }

    public void changeMoveStrategy(MoveWorkerStrategy moveWorker) {
        this.moveWorker = moveWorker;
    }

    public Effect() {

    }

    public void changeMoveStrategy(RestraintsCellsStrategy restraintsCells) {
        this.restraintsCells = restraintsCells;
    }

    public List<Cell> doShowSelectOptions(Match match) {
        return showSelectOptions.showSelect(match);
    }

    public Worker doSelectOptions(Turn turn, int inputX, int inputY) {
        return selectOptions.select(turn, inputX, inputY);
    }

    public Cell[] doMoveOptions(Worker selectedWorker, Turn turn) {
        return restraintsCells.restraintsCells(selectedWorker, turn);
    }

    public void doMoveWorker(Worker selectedWorker, Cell selectedCells) {
        moveWorker.moveWorker(selectedWorker, selectedCells);
    }

    public boolean doWinCheck(Turn turn) {
        return winCheck.winCheck(turn);
    }

    public void doPossibleSecondMove(Worker selectedWorker, Cell selectedCells, Turn turn) {
        possibleSecondMove.possibleSecondMove(selectedWorker, selectedCells, turn);
    }

    public List<Cell> doShowBuildOptions(Worker worker) {
        return showBuildOptions.showBuildOptions(worker);
    }

    public void doBuildBlock(int blockX, int blockY, Turn turn) {
        buildBlock.buildBlock(blockX, blockY, turn);
    }

    public boolean getStatus() {
        return isActive;
    }

    public Match getMap() {
        return associatedCard.getOwner().getCurrentMatch();
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
