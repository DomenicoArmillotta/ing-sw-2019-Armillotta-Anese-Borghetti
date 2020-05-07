package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.Cell;

public class BuildBlockEvent extends Event {
    Cell cellWithBlock;

    public BuildBlockEvent(Cell cellWithBlock) {
        this.cellWithBlock = cellWithBlock;
    }

    public Cell getCellWithBlock() {
        return cellWithBlock;
    }

    public void eventMethod() {
        ;
    }
}
