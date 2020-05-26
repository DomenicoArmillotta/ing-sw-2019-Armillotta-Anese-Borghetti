package it.polimi.ingsw.client.proxymodel;

public class WorkerClient {
    private String color;
    private int isSelected;

    public int getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }

    private Coords position;
    private Player owner;
    public  WorkerClient(Player owner,Coords coords,int index){
        this.owner=owner;
        this.position=coords;
        if(index == 0)
            this.setColor("\033[1;34m"); //BLUE_BOLD
        else if(index == 1)
            this.setColor("\033[1;35m"); //PURPLE
        else if(index == 2)
            this.setColor("\033[1;33m"); //YELLOW

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

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
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
