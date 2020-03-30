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
        int x = 5, y = 5; /* Esempio */
        int z = 10, w = 10; /* Esempio */
        Worker activeWorker = new Worker();
        Cell focusCell = new Cell();
        activeWorker = ((currentPlayer.getPlayerGod()).getEffect()).doSelectOptions(x, y);
        focusCell = ((currentPlayer.getPlayerGod()).getEffect()).doMoveOptions(activeWorker);
        ((currentPlayer.getPlayerGod()).getEffect()).doMoveWorker(focusCell);
        if(((currentPlayer.getPlayerGod()).getEffect()).doWinCheck()) {
            /* Vittoria */
        }
        ((currentPlayer.getPlayerGod()).getEffect()).doBuildBlock(z, w);
    }

    public void nextTurn() {
        Player tempPlayer = new Player();
        tempPlayer = currentPlayer;
        currentPlayer = nextPlayer;
        nextPlayer = prevPlayer;
        prevPlayer = tempPlayer;
    }

}
