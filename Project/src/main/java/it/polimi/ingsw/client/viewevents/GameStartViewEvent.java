package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.ClientStatus;
import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameStartViewEvent extends ViewEvent {
    String firstPlayer;
    String secondPlayer;
    String thirdPlayer;
    public GameStartViewEvent(String firstPlayer, String secondPlayer, String thirdPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {
        System.out.println("firstPlayer "+firstPlayer);
        ClientStatus.instance().setCurrentPlayer(firstPlayer);
        ClientStatus.instance().setGameIsRunning(true);
    }
}
