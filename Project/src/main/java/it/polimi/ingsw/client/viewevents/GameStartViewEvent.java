package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.ClientStatus;
import it.polimi.ingsw.client.GamePhase;
import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameStartViewEvent extends ViewEvent {
    String firstPlayer;
    String secondPlayer;
    String thirdPlayer;
    ProxyModel proxyModel = ProxyModel.instance();
    ClientStatus clientStatus = ClientStatus.instance();

    public GameStartViewEvent(String firstPlayer, String secondPlayer, String thirdPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {
        proxyModel.createTurn();
        proxyModel.getTurn().setCurrentPlayer(new Player(firstPlayer));
        proxyModel.getTurn().setNextPlayer(new Player(secondPlayer));
        proxyModel.getTurn().setPreviousPlayer(new Player(thirdPlayer));
        //clientStatus.setGamePhase(GamePhase.GAME);
        System.out.println("Game is starting... Type anything to start");
        /* ClientStatus.instance().setGameIsRunning(true); */
    }
}
