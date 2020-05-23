package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class GodCorrectlyChosen extends EventBean {
    String chosenGod;
    String player;

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
