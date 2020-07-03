package it.polimi.ingsw.client;

/**
 * the event is sent to the server by the client,
 * with the information of who made the communications and the number of players of the game
 */
public class StartUpEvent extends ClientEvent {
    String playerComm;
    String numberOfPlayers;

    public StartUpEvent(String playerComm, String numberOfPlayers) {
        this.playerComm = playerComm;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(String numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getPlayerComm() {
        return playerComm;
    }

    public void setPlayerComm(String playerComm) {
        this.playerComm = playerComm;
    }
}
