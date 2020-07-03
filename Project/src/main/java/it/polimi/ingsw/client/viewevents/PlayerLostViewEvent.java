package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * shows on screen who loses the game
 */
public class PlayerLostViewEvent extends ViewEvent {
    String loserName;
    ProxyModel proxyModel = ProxyModel.instance();
    public PlayerLostViewEvent(String loserName) {
        this.loserName = loserName;
    }

    /**
     * shows on screen who loses the game
     */
    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().drawLooseGame(loserName);
    }
}
