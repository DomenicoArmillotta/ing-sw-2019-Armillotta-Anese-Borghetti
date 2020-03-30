package it.polimi.ingsw;

public class Effect {
    private GodCard associatedCard;
    private SelectOptionsStrategy selectOptions;
    private MoveOptionsStrategy moveOptions;
    private MoveWorkerStrategy moveWorker;
    private WinCheckStrategy winCheck;
    private BuildBlockStrategy buildBlock;
    private PossibleMoveStrategy possibleMove;
    private boolean isActive;


    public GodCard getPrevPlayerGod(){
        return this.getAssociatedCard().getOwner().getMatch().getCurrentTurn().getPrevPlayer().getPlayerGod();
    }
    public GodCard getNextPlayerGod(){
        return this.getAssociatedCard().getOwner().getMatch().getCurrentTurn().getNextPlayer().getPlayerGod();
    }

    public Effect(GodCard associatedCard){
        this.associatedCard=associatedCard;
        //fare switch
        String apollo = "APOLLO";
        String atena="ATENA";

        if (!(string1.compareTo(associatedCard.getGodName()))){
            SelectOptionsStrategy selectOptions=new BasicSelectOptionsConcrete() ;
            this.selectOptions=selectOptions;
            if(this.getNextPlayerGod().getGodName().compareTo(string2))
            MoveOptionsStrategy moveOptionsStrategy= new


        }
        //....

    }

    publc void setEffectStrategies() {
        /* Apply Strategy Method */
    }

    public changeMoveStrategy(MoveOptionsStrategy newMoveOptions) {
        this.moveOptions = newMoveOptions;
    }

    public Worker doSelectOptions(int x, int y) {
        /* return selectOptions.select(x, y); */
    }
    public Cell doMoveOptions(Worker selectedWorker) {
        /* return moveOptions.moveOptions(selectedWorker); */
    }
    public void doMoveWorker(Cell selectedCell) {
        /* moveWorker.moveWorker(selectedCell); */
    }
    public boolean doWinCheck() {
        /* return winCheck.winCheck(); */
    }
    public void doBuildBlock(int x, int y) {
        /* buildBlock.buildBlock(x, y); */
    }
    public boolean getStatus() {
        /* return this.isActive; */
    }
    public Map getMap() {
        /* return ((associatedCard.getOwner()).getMatch()).getMap(); */
    }
}
