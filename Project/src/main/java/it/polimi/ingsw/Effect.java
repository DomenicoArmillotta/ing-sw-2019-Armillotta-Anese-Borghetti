package it.polimi.ingsw;

public class Effect {
    private GodCard associatedCard;
    private SelectOptionsStrategy selectOptions;
    private MoveOptionsStrategy moveOptions;
    private MoveWorkerStrategy moveWorker;
    private WinCheckStrategy winCheck;
    private BuildBlockStrategy buildBlock;
    private PossibleSecondMoveStrategy possibleMove;
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

    public Effect(GodCard associatedCard){
        this.associatedCard=associatedCard;

        if(this.associatedCard.getGodName().equals("Apollo")){
            /* Scelta delle strategy per Apollo */
        }else if(this.associatedCard.getGodName().equals("Artemide")){
            /* Scelta delle strategy per Artemide */
        }else if(this.associatedCard.getGodName().equals("Atena")){
            /* Scelta delle strategy per Atena */
        }else if(this.associatedCard.getGodName().equals("Atlante")){
            /* Scelta delle strategy per Atlante */
        }else if(this.associatedCard.getGodName().equals("Demetra")){
            /* Scelta delle strategy per Demetra */
        }else if(this.associatedCard.getGodName().equals("Efesto")){
            /* Scelta delle strategy per Efesto */
        }else if(this.associatedCard.getGodName().equals("Minotauro")){
            /* Scelta delle strategy per Minotauro */
        }else if(this.associatedCard.getGodName().equals("Pan")){
            /* Scelta delle strategy per Pan */
        }else if(this.associatedCard.getGodName().equals("Prometeo")){
            /* Scelta delle strategy per Prometeo */
        }

    }

    public void changeMoveStrategy(MoveOptionsStrategy newMoveOptions) {
        this.moveOptions = newMoveOptions;
    }

    public Worker doSelectOptions(int x, int y) {
        /* return selectOptions.select(x, y); */
        return associatedCard.getOwner().getFirstWorker();
    }
    public Cell doMoveOptions(Worker selectedWorker) {
        /* return moveOptions.moveOptions(selectedWorker); */
        return associatedCard.getOwner().getFirstWorker().getCurrentPosition();
    }
    public void doMoveWorker(Cell selectedCell) {
        /* moveWorker.moveWorker(selectedCell); */
    }
    public boolean doWinCheck() {
        /* return winCheck.winCheck(); */
        return false;
    }
    public void doBuildBlock(int x, int y) {
        /* buildBlock.buildBlock(x, y); */
    }
    public boolean getStatus() {
        /* return this.isActive; */
        return isActive;
    }
    public Map getMap() {
        /* return ((associatedCard.getOwner()).getMatch()).getMap(); */
        return associatedCard.getOwner().getMatch().getMap();
    }
}
