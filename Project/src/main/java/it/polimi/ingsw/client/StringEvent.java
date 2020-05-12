package it.polimi.ingsw.client;

import java.io.Serializable;

public class StringEvent extends ClientEvent implements Serializable {
    String payload;

    StringEvent(String payload) {
        eventType = "CoordsEvent";
        this.payload = payload;
    }
}
