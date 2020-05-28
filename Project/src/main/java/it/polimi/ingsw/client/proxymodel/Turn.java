package it.polimi.ingsw.client.proxymodel;

public class Turn {
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;

    public void nextTurn() {
        Player tempPlayer = null;
        tempPlayer = this.currentPlayer;
        if(this.nextPlayer.equals(this.prevPlayer)){
            this.currentPlayer = this.prevPlayer;
            this.prevPlayer=tempPlayer;
            this.nextPlayer=tempPlayer;
        }else {
            currentPlayer = nextPlayer;
            nextPlayer = prevPlayer;
            prevPlayer = tempPlayer;
        }
        /* System.out.println("Turno di "+currentPlayer.getName()); */
    }

    public Player getPlayerByName(String name) {
        if(currentPlayer.getName().equals(name))
            return currentPlayer;
        else if(nextPlayer.getName().equals(name))
            return nextPlayer;
        else if(prevPlayer.getName().equals(name))
            return prevPlayer;
        else return null;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public Player getPreviousPlayer() {
        return prevPlayer;
    }

    public void setPreviousPlayer(Player previousPlayer) {
        this.prevPlayer = previousPlayer;
    }

}
