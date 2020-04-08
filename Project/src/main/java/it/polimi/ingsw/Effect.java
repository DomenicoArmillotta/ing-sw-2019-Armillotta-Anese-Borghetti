package it.polimi.ingsw;

public class Effect {
    private GodCard associatedCard;
    private SelectOptionsStrategy selectOptions;
    private RestraintsCellsStrategy restraintsCells;
    private MoveWorkerStrategy moveWorker;
    private WinCheckStrategy winCheck;
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

    public void setEffectStrategies(SelectOptionsStrategy selectOptions, RestraintsCellsStrategy restraintsCells,
                                    MoveWorkerStrategy moveWorker, WinCheckStrategy winCheck,
                                    PossibleSecondMoveStrategy possibleSecondMove, BuildBlockStrategy buildBlock) {
        this.selectOptions = selectOptions;
        this.restraintsCells = restraintsCells;
        this.moveWorker = moveWorker;
        this.winCheck = winCheck;
        this.possibleSecondMove = possibleSecondMove;
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

    public Worker doSelectOptions(Turn turn) {
        return selectOptions.select(turn);
    }

    public Cell[] doMoveOptions(Worker selectedWorker, Turn turn) {
        return restraintsCells.restraintsCells(selectedWorker, turn);
    }

    public void doMoveWorker(Worker selectedWorker, Cell selectedCells, Turn turn) {
        moveWorker.moveWorker(selectedWorker, selectedCells, turn);
    }

    public boolean doWinCheck(Turn turn) {
        return winCheck.winCheck(turn);
    }

    public void doPossibleSecondMove(Worker selectedWorker, Cell selectedCells, Turn turn) {
        possibleSecondMove.possibleSecondMove(selectedWorker, selectedCells, turn);
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
