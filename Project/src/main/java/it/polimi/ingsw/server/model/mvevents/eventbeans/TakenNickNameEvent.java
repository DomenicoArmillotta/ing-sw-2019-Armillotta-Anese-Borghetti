package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class TakenNickNameEvent extends EventBean{
    private String takenNickNamePlayer;

    public String getTakenNickNamePlayer() {
        return takenNickNamePlayer;
    }

    public TakenNickNameEvent(String takenId) {
        this.takenNickNamePlayer = takenId;
    }

    public void setTakenNickNamePlayer(String takenId) {
        this.takenNickNamePlayer = takenId;
    }
}
