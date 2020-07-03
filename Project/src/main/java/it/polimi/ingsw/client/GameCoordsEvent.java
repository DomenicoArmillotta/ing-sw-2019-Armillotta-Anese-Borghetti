package it.polimi.ingsw.client;

import java.io.Serializable;
/**
 * the event is sent to the server by the client,with the information of the coordinates
 */
public class GameCoordsEvent extends ClientEvent implements Serializable {
    int x;
    int y;

    public GameCoordsEvent(int x, int y) {
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
