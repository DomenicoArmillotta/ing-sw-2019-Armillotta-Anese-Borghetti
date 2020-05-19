package it.polimi.ingsw.client.proxymodel;

public class WorkerClient {
    private int color;
    private Coords position;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public char getGiovatore() {
        return giovatore;
    }

    public void setGiovatore(char giovatore) {
        this.giovatore = giovatore;
    }

    private char giovatore;
    private final char symbol='@';


    public int getColor() {
        return color;
    }

    public Coords getPosition() {
        return position;
    }

    public void setPosition(Coords position) {
        this.position = position;
    }

    public char getSymbol() {
        return symbol;
    }
}
