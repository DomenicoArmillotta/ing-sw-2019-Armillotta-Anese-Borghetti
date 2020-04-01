package it.polimi.ingsw;

/*

 /\_/\
( o.o )
 > ^ <

 */

public class Effect {
    private GodCard associatedCard;
    private SelectOptionsStrategy selectOptions;
    private MoveOptionsStrategy moveOptions;
    private MoveWorkerStrategy moveWorker;
    private WinCheckStrategy winCheck;
    private BuildBlockStrategy buildBlock;
    private PossibleSecondMoveStrategy possibleSecondMove;
    private boolean isActive;

    public GodCard getAssociatedCard() {
        return associatedCard;
    }
    public GodCard getPrevPlayerGod(){
        return this.getAssociatedCard().getOwner().getMatch().getCurrentTurn().getPrevPlayer().getPlayerGod();
    }
    public GodCard getNextPlayerGod(){
        return this.getAssociatedCard().getOwner().getMatch().getCurrentTurn().getNextPlayer().getPlayerGod();
    }

    public void setEffectStrategies(SelectOptionsStrategy selectOptions, MoveOptionsStrategy moveOptions,
                                    MoveWorkerStrategy moveWorker, WinCheckStrategy winCheck,
                                    PossibleSecondMoveStrategy possibleSecondMove, BuildBlockStrategy buildBlock) {
        this.selectOptions = selectOptions;
        this.moveOptions = moveOptions;
        this.moveWorker = moveWorker;
        this.winCheck = winCheck;
        this.possibleSecondMove = possibleSecondMove;
        this.buildBlock = buildBlock;
    }

    public Effect(){
        if(this.associatedCard.getGodName().equals("Apollo")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new MoveSwitchingWorkersConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new BasicBuildConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Artemide")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new MoveFirstTimeForwardConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new MoveSecondTimeForwardConcrete();
               this.buildBlock = new BasicBuildConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Atena")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new MoveCheckingLevelConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new BasicBuildConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Atlante")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new BasicMoveConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new InstantBuildDomeConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Demetra")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new BasicMoveConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new BuildTwiceDifferentCellConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Efesto")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new BasicMoveConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new BuildTwiceSameCellConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Minotauro")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new MovePushingWorkerConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new BasicBuildConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Pan")){
            /* this.selectOptions = new BasicSelectOptionsConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new BasicMoveConcrete();
               this.winCheck = new WinIfTwoLevelsDownConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new BasicBuildConcrete(); */
        } else if(this.associatedCard.getGodName().equals("Prometeo")){
            /* this.selectOptions = new SelectBuildOrMoveConcrete();
               this.moveOptions = new BasicMoveOptionsConcrete();
               this.moveWorker = new BasicMoveConcrete();
               this.winCheck = new BasicWinCheckConcrete();
               this.possibleSecondMove = new NoSecondMoveConcrete();
               this.buildBlock = new BuildBeforeAndAfterMoveConcrete(); */
        }

    }

    public void changeMoveStrategy(MoveOptionsStrategy newMoveOptions) {
        this.moveOptions = newMoveOptions;
    }

    public Worker doSelectOptions(int x, int y) {
        return selectOptions.select(x, y);
    }
    public Cell doMoveOptions(Worker selectedWorker) {
        return moveOptions.moveOptions(selectedWorker);
    }
    public void doMoveWorker(Worker selectedWorker, Cell selectedCell) {
        moveWorker.moveWorker(selectedWorker, selectedCell);
    }
    public boolean doWinCheck() {
        return winCheck.winCheck();
    }
    public void doPossibleSecondMove(Worker selectedWorker, Cell selectedCell) {
        possibleSecondMove.possibleSecondMove(selectedWorker, selectedCell);
    }
    public void doBuildBlock(int x, int y) {
        buildBlock.buildBlock(x, y);
    }
    public boolean getStatus() {
        return isActive;
    }
    public Map getMap() {
        return associatedCard.getOwner().getMatch().getMap();
    }
}
