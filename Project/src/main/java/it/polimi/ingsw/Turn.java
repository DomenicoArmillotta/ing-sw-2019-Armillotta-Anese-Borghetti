package it.polimi.ingsw;

import java.util.*;

public class Turn {
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;
    private Match match;

    public Turn(Match match, List<Player> playersQueue) {
        this.match = match;
        if((this.getMatch().getGameMaster().getNumOfPlayers())==2) {
            this.currentPlayer = playersQueue.get(0);
            this.nextPlayer = playersQueue.get(1);
            this.prevPlayer = playersQueue.get(1);
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
        /* OUTPUT display mappa */
        /* int cellX = 5, cellY = 5; */
        int blockX = 10, blockY = 10;

        Worker selectedWorker = ((currentPlayer.getPlayerGod()).getEffect()).doSelectOptions();
        Cell selectedCell = ((currentPlayer.getPlayerGod()).getEffect()).doMoveOptions(selectedWorker);
        ((currentPlayer.getPlayerGod()).getEffect()).doMoveWorker(selectedWorker, selectedCell);

        if(((currentPlayer.getPlayerGod()).getEffect()).doWinCheck()) {
            /* Codice eseguito in caso di vittoria */
        }
        ((currentPlayer.getPlayerGod()).getEffect()).doPossibleSecondMove(selectedWorker, selectedCell);
        ((currentPlayer.getPlayerGod()).getEffect()).doBuildBlock(blockX, blockY);
    }

    public void nextTurn() {
        Player tempPlayer = currentPlayer;
        currentPlayer = nextPlayer;
        nextPlayer = prevPlayer;
        prevPlayer = tempPlayer;
    }

}
