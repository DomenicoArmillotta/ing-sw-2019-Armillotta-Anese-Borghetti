package it.polimi.ingsw.networktests.communication;

import java.io.Serializable;

public class FakeCoordsEvent implements Serializable {
    int x;
    int y;
    public FakeCoordsEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
