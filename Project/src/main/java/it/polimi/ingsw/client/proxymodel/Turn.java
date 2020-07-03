package it.polimi.ingsw.client.proxymodel;

/**
 * manages turn, memorizing the prev, post and current player
 */
public class Turn {
    int turns_num = 0;
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;

    /**
     *this function advances the turn by correctly setting the previous turn and the next turn
     */
    public void nextTurn() {
        //System.out.println("CLIENT NEXT TURN");
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
        turns_num++;
        /* System.out.println("Numero di turni: "+turns_num); */
        /* System.out.println("Turno di "+currentPlayer.getName()); */
    }

    /**
     * from the string name returns the player
     * @param name name of the player I want returned
     * @return the player that matches the name
     */
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
