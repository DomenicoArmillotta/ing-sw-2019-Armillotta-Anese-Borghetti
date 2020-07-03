package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 *create GodCorrectlyChosen which will be sent to the client by the server
 */
public class GodCorrectlyChosen extends EventBean {
    String chosenGod;
    String player;

    /**
     * create GodCorrectlyChosen which will be sent to the client by the server
     * to communicate the correct pairing between player and god
     * @param chosenGod
     * @param player
     */
    public GodCorrectlyChosen(String chosenGod, String player) {
        this.chosenGod = chosenGod;
        this.player = player;
    }

    public String getChosenGod() {
        return chosenGod;
    }

    public String getPlayer() {
        return player;
    }

    public void setChosenGod(String chosenGod) {
        this.chosenGod = chosenGod;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
