package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerLostViewEvent extends ViewEvent {
    String loserName;
    ProxyModel proxyModel = ProxyModel.instance();
    public PlayerLostViewEvent(String loserName) {
        this.loserName = loserName;
    }

    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().drawLooseGame(loserName);
    }
}
