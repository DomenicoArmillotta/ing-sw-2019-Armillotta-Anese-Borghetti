package it.polimi.ingsw.client;

import java.io.Serializable;

public class CoordsEvent extends ClientEvent implements Serializable {
    int x;
    int y;

    public CoordsEvent(int x, int y, String clientID) {
        this.clientID = clientID;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
