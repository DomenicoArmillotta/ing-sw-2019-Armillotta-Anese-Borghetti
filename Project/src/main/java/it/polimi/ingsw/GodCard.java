package it.polimi.ingsw;
public class GodCard {
    private String godName;
    private String description;
    private String specialRules;
    private Effect effect;
    private Player owner;

    public GodCard(String godName){
        this.godName=godName;
        this.owner=owner;
            if (this.godName.equals("Apollo")) {
                this.description = ("");
                this.specialRules = ("");
            } else if (this.godName.equals("Artemide")) {
                this.description = ("");
                this.specialRules = ("");

            } else if (this.godName.equals("Atena")) {
                this.description = ("");
                this.specialRules = ("");

            } else if (this.godName.equals("Atlante")) {
                this.description = ("");
                this.specialRules = ("");

            } else if (this.godName.equals("Demetra")) {
                this.description = ("");
                this.specialRules = ("");

            } else if (this.godName.equals("Efesto")) {
                this.description = ("");
                this.specialRules = ("");

            } else if (this.godName.equals("Minotauro")) {
                this.description = ("");
                this.specialRules = ("");

            } else if (this.godName.equals("Pan")) {
                this.description = ("");
                this.specialRules = ("");

            } else if (this.godName.equals("Prometeo")) {
                this.description = ("");
                this.specialRules = ("");
            }
        }
    }

    public String getGodName() {
        return godName;
    }
    public String getDescription() {
        return description;
    }
    public String getSpecialRules() {
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

