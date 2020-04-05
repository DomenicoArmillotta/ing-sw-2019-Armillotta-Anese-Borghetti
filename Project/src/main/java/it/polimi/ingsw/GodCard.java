package it.polimi.ingsw;
public class GodCard {
    private String godName;
    private String description;
    private Effect effect;
    private Player owner;

    public GodCard(String godName,String description){
        this.godName=godName;
        this.description=description;
    }

    public String getGodName() {
        return godName;
    }
    public String getDescription() {
        return description;
    }

    public void setEffect(Effect effect){
        this.effect=effect;
    }
    public Effect getEffect(){
        return this.effect;
    }

    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner){this.owner=owner;}
    }

