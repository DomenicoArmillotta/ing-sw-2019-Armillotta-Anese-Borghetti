package it.polimi.ingsw.client.proxymodel;

/**
 * This Coords represent the couple of integer coordinates that identifies a cell in the game's grid
 */

public class Coords {
    private int x;
    private int y;
    public Coords(int x,int y){
        this.x=x;
        this.y=y;
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
