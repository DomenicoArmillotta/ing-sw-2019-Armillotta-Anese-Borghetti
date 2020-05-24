package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerWonViewEvent extends ViewEvent {
    String winnerName;
    ProxyModel proxyModel = ProxyModel.instance();
    public PlayerWonViewEvent(String winnerName) {
        this.winnerName = winnerName;
    }

    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().drawWinGame();
    }
}
