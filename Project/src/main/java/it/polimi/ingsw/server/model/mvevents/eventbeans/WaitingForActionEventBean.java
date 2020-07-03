package it.polimi.ingsw.server.model.mvevents.eventbeans;
import it.polimi.ingsw.server.model.mvevents.actionevents.Coordinates;

import java.util.List;

/**
 * display all the available cells for a particular power
 */
public class WaitingForActionEventBean extends EventBean {
    private List<Coordinates> coordinates;
    private String currTurn;

    public WaitingForActionEventBean(List<Coordinates> coordinates,String currTurn) {
        this.coordinates = coordinates;
        this.currTurn = currTurn;
    }

    public String getCurrTurn() {
        return currTurn;
    }

    public void setCurrTurn(String currTurn) {
        this.currTurn = currTurn;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }
}
