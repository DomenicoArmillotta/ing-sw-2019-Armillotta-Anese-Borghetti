package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerLostViewEvent extends ViewEvent {
    String loserName;
    public PlayerLostViewEvent(String loserName) {
        this.loserName = loserName;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {
        //ProxyModel.instance().getDrawerStrategy().drawLooseGame();

    }
}
