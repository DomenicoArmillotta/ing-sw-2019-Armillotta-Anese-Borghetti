package it.polimi.ingsw;
/*
    private char[] godName;
    private char[] description;
    private char[] specialRules;
    private boolean isActive;
    int effectDuration;

    public void setEffectDuration(int )
    public char[] getGodName()
    public char[] getDescription()
    public char[] getSpecialRules()
    public boolean getStatus()
    public int getEffectDuration()
    public void activate()
    public void deactivate()
    public void reduceEffectDuration()
 */

public class GodCard {
    private char[] godName;
    private char[] description;
    private char[] specialRules;
    private boolean isActive;
    int effectDuration;

    public void setEffectDuration(int effectDuration) {
        this.effectDuration = effectDuration;
    }

    public char[] getGodName() {
        return godName;
    }

    public char[] getDescription() {
        return description;
    }

    public char[] getSpecialRules() {
        return specialRules;
    }

    public boolean getStatus() {
        return isActive;
    }

    public int getEffectDuration() {
        return effectDuration;
    }
    public void activate(){

    }
    public void deactivate(){

    }
    public void reduceEffectDuration(){

    }
}
