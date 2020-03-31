package it.polimi.ingsw;

import java.util.ArrayList;

public class Turn {
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;
    private Match match;

    public Turn(Match match, ArrayList<Player> playersQueue) {
        this.match = match;
        if((this.getMatch().getGameMaster().getNumOfPlayers())==2) {
            this.currentPlayer = playersQueue.get(0);
            this.nextPlayer = playersQueue.get(1);
            this.prevPlayer = playersQueue.get(0);
        } else if((this.getMatch().getGameMaster().getNumOfPlayers())==3) {
            this.currentPlayer = playersQueue.get(0);
            this.nextPlayer = playersQueue.get(1);
            this.prevPlayer = playersQueue.get(2);
        }
    }

    public Match getMatch() {
        return match;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
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
