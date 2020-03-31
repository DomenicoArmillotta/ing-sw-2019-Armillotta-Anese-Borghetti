package it.polimi.ingsw;

public class Turn {
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public Player getPrevPlayer() {
        return prevPlayer;
    }

    public void executeTurn() {
        int cellX = 5, cellY = 5;
        int blockX = 10, blockY = 10;
        Worker selectedWorker = ((currentPlayer.getPlayerGod()).getEffect()).doSelectOptions(cellX, cellY);
        Cell selectedCell = ((currentPlayer.getPlayerGod()).getEffect()).doMoveOptions(selectedWorker);
        ((currentPlayer.getPlayerGod()).getEffect()).doMoveWorker(selectedWorker, selectedCell);
        if(((currentPlayer.getPlayerGod()).getEffect()).doWinCheck()) {
            /* Codice eseguito in caso di vittoria */
        }
        ((currentPlayer.getPlayerGod()).getEffect()).doPossibleSecondMove(selectedWorker, selectedCell);
        ((currentPlayer.getPlayerGod()).getEffect()).doBuildBlock(blockX, blockY);
    }

    public void nextTurn() {
        Player tempPlayer = new Player();
        tempPlayer = currentPlayer;
        currentPlayer = nextPlayer;
        nextPlayer = prevPlayer;
        prevPlayer = tempPlayer;
    }

}
