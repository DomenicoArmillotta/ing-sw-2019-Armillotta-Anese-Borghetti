package it.polimi.ingsw.server.model;

public enum Level {
    GROUND,
    BASE,
    MID,
    TOP,
    DOME;

    /**
     * return the number corresponds to the level
     * @return return the level number
     */
    public Level getNext() {
        return this.ordinal() < Level.values().length - 1
                ? Level.values()[this.ordinal() + 1]
                : null;
    }
}



