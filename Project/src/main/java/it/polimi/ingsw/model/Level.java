package it.polimi.ingsw.model;

public enum Level {
    GROUND,
    BASE,
    MID,
    TOP,
    DOME;

    public Level getNext() {
        return this.ordinal() < Level.values().length - 1
                ? Level.values()[this.ordinal() + 1]
                : null;
    }
}



