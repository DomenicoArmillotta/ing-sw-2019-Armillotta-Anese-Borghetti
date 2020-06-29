package it.polimi.ingsw.client.viewevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.polimi.ingsw.client.ClientAckDisconnectionEvent;
import it.polimi.ingsw.client.ClientSocketManager;
import it.polimi.ingsw.client.proxymodel.ProxyModel;


import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionInterruptViewEvent extends ViewEvent{
    private String faultyClient;
    ProxyModel proxyModel = ProxyModel.instance();
    Socket socket = proxyModel.thisScoket;


    public ConnectionInterruptViewEvent(String faultyClient){
        this.faultyClient = faultyClient;
        this.proxyModel = ProxyModel.instance();
    }

    @Override
    public void viewEventMethod(){
        proxyModel.getDrawerStrategy().drawConnectionInterrupt();
        proxyModel.setPhase(-1);
    }
}
