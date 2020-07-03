package it.polimi.ingsw.client;
/**
 * the event is sent to the server by the client,with the information of the chosen god and the player that chose
 */
public class GodChoiceEvent extends ClientEvent {
    String chosenGod;
    String player;

    public GodChoiceEvent(String chosenGod, String player) {
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
