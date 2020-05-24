package it.polimi.ingsw.client.proxymodel;

public class WorkerClient {
    private int color;
    private int isSelected;

    public int getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }

    private Coords position;
    private Player owner;
    public  WorkerClient(Player owner,Coords coords){
        this.owner=owner;
        this.position=coords;

    }
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
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
