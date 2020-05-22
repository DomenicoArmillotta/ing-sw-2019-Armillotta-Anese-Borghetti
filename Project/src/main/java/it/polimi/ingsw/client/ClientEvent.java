package it.polimi.ingsw.client;

import java.io.Serializable;

public class ClientEvent implements Serializable {
    protected String clientID;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
