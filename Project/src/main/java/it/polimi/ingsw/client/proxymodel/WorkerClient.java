package it.polimi.ingsw.client.proxymodel;

/**
 *
 * it contains all the worker information including the position, the owner and if it is selected,
 * useful information for the cli,
 *  which colors differently according to the owner and does operations based on the position
 */
public class WorkerClient {
    private String color;
    private Coords position;
    private Player owner;
    private int isSelected;

    public int getIsSelected() {
        return isSelected;
    }

    public void select() {
        this.isSelected = 1;
    }

    public void unselect() {
        this.isSelected = 0;
    }

    public WorkerClient(Player owner,Coords coords,int index){
        this.owner=owner;
        this.position=coords;
        if(index == 0)
            this.setColor("\033[1;34m");
        else if(index == 1)
            this.setColor("\033[1;35m");
        else if(index == 2)
            this.setColor("\033[1;33m");

    }
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

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

}
