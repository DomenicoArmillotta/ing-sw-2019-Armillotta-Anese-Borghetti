package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.client.CoordsEvent;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.WaitingForActionEventBean;
import it.polimi.ingsw.server.model.powertree.Power;

import java.util.ArrayList;
import java.util.List;

public class WaitingForActionEvent extends ActionEvent { /* Waiting for select / Waiting for build */
    private List<Cell> availableCells;

    public WaitingForActionEvent(List<Cell> availableCells) {
        this.availableCells = availableCells;
    }

    private List<Cell> getAvailableCells() {
        return availableCells;
    }

    public EventBean eventMethod() {
        List<Coordinates> coordinates = new ArrayList<>();
        int i;
        for(i = 0; i < availableCells.size(); i++) {
            Coordinates c = new Coordinates();
            c.setX(availableCells.get(i).getX());
            c.setY(availableCells.get(i).getY());
            coordinates.add(c);
        }

        return new WaitingForActionEventBean(coordinates,ActionExecutor.instance().getCurrentPlayer().getName());
    }

}
