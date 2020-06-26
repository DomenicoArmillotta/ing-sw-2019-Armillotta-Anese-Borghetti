package it.polimi.ingsw.client;

public class ClientAckDisconnectionEvent  extends ClientEvent{
    private String socketToDisconnect;

    public ClientAckDisconnectionEvent(String socketToDisconnect) {
        this.socketToDisconnect = socketToDisconnect;
    }

    public String getSocketToDisconnect() {
        return socketToDisconnect;
    }

    public void setSocketToDisconnect(String socketToDisconnect) {
        this.socketToDisconnect = socketToDisconnect;
    }
}
