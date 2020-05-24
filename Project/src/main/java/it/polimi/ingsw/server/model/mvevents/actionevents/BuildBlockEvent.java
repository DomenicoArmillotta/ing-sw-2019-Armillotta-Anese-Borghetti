package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.mvevents.eventbeans.BuildBlockEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class BuildBlockEvent extends ActionEvent {
    Cell cellWithBlock;

    public BuildBlockEvent(Cell cellWithBlock) {
        this.cellWithBlock = cellWithBlock;
    }

    private Cell getCellWithBlock() {
        return cellWithBlock;
    }

    public EventBean eventMethod() {
        BuildBlockEventBean buildBlockEventBean = new BuildBlockEventBean(getCellWithBlock().getX(), getCellWithBlock().getY(), getCellWithBlock().getBuildingLevel().ordinal());
        return buildBlockEventBean;
    }
}
