package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TakenNickNameViewEvent extends ViewEvent {
    String takenNickName;
    public TakenNickNameViewEvent(String takenNickName) {
        this.takenNickName = takenNickName;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {


    }
}
