package it.polimi.ingsw.client;

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
