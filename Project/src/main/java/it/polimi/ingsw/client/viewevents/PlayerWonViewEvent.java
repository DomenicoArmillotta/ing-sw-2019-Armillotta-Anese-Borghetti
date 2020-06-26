package it.polimi.ingsw.client.viewevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.polimi.ingsw.client.ClientAckDisconnectionEvent;
import it.polimi.ingsw.client.proxymodel.*;

import java.net.Inet4Address;

import java.net.Socket;
import java.net.UnknownHostException;

public class PlayerWonViewEvent extends ViewEvent {
    String winnerName;
    ProxyModel proxyModel = ProxyModel.instance();
    Socket socket = proxyModel.thisScoket;

    public PlayerWonViewEvent(String winnerName) {
        this.winnerName = winnerName;
    }

    public void viewEventMethod() throws UnknownHostException, JsonProcessingException {
        System.out.println("hai vinto");
        ProxyModel.instance().sendAutonomousEvents(new ClientAckDisconnectionEvent(Integer.toString(socket.getLocalPort())));
        proxyModel.getDrawerStrategy().drawWinGame();
    }
}
