package it.polimi.ingsw;
public class GodCard {
    private String godName;
    private String description;
    private String specialRules;
    private Effect effect;
    private Player owner;
    //mettere stringhe e finire costruttore


    public GodCard(char[] godName,Player owner){
        this.godName=godName;
        this.owner=owner;
    }

    public String getGodName() {
        return godName;
    }
    public char[] getDescription() {
        return description;
    }
    public char[] getSpecialRules() {
        return specialRules;
    }
    public void createEffect(){
        Effect effect = new Effect(this);
        this.effect=effect;
    }
    public Effect getEffect(){
        return this.effect;
    }

    public Player getOwner() {
        return owner;
    }
}
