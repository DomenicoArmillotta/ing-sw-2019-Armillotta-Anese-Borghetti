package it.polimi.ingsw.client.viewevents;

public class TakenNickNameViewEvent extends ViewEvent {
    String takenNickName;
    public TakenNickNameViewEvent(String takenNickName) {
        this.takenNickName = takenNickName;
    }
    public boolean startWaiting() {
        return false;
    }
}
