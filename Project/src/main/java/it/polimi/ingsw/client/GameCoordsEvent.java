package it.polimi.ingsw.client;

import java.io.Serializable;

public class GameCoordsEvent extends CoordsEvent implements Serializable {
    public GameCoordsEvent(int x, int y, String clientID) {
        super(x, y, clientID);
    }
}
