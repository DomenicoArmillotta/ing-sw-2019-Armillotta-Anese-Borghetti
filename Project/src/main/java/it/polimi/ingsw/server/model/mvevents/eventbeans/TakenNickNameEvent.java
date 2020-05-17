package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class TakenNickNameEvent extends EventBean{
    private String takenNickNamePlayer;

    public String getMessage() {
        return takenNickNamePlayer;
    }

    public TakenNickNameEvent(String takenId) {
        this.takenNickNamePlayer = takenId;
    }

    public void setMessage(String takenId) {
        this.takenNickNamePlayer = takenId;
    }
}
