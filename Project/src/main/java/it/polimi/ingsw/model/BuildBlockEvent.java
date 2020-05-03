package it.polimi.ingsw.model;

public class BuildBlockEvent implements Event {
    Cell cellWithBlock;

    public BuildBlockEvent(Cell cellWithBlock) {
        this.cellWithBlock = cellWithBlock;
    }

    public Cell getCellWithBlock() {
        return cellWithBlock;
    }
}
