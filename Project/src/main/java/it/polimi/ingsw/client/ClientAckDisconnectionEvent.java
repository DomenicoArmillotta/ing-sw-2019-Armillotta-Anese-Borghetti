package it.polimi.ingsw.client;
/**
 * the event first encoded with a xml encoder, is sent to the server by the client,with the info of socket To Disconnect
 */
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
