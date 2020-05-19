package it.polimi.ingsw.client;

import java.io.Serializable;

public class StringEvent extends ClientEvent implements Serializable {
    String payload;

    StringEvent(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }
}
