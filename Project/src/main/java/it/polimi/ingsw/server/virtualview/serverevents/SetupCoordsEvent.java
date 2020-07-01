package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CommandFailureEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.SetupWorkerDoneEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class SetupCoordsEvent extends CoordsEvent {
    int firstWorkerX;
    int firstWorkerY;
    int secondWorkerX;
    int secondWorkerY;
    List<Integer> caratteri = Arrays.asList(0,1,2,3,4);


    public SetupCoordsEvent(int firstWorkerX, int firstWorkerY, int secondWorkerX, int secondWorkerY) {
        this.firstWorkerX = firstWorkerX;
        this.firstWorkerY = firstWorkerY;
        this.secondWorkerX = secondWorkerX;
        this.secondWorkerY = secondWorkerY;
    }

    public void serverEventMethod(Controller controller) {
        /* non accede al controller*/
        if((this.firstWorkerX>=0 && this.firstWorkerX<5)&&(this.firstWorkerY>=0 && this.firstWorkerY<5)&&(this.secondWorkerY>=0 && this.secondWorkerY<5)&&(this.secondWorkerX>=0 && this.secondWorkerX<5) ){

            if(this.secondWorkerX!=this.firstWorkerX || this.secondWorkerY!=this.firstWorkerY) {
                if (!correctSetUpCoordinatesCheck()) {
                    EventsBuffer.instance().setLastEventBean(new CommandFailureEventBean("coordinates format non valid, reinsert with a valid format (numbers 0-9)"));
                    return;
                }

                if (!areCellsOccupied()) {
                    ActionExecutor.instance().getCurrentPlayer().workersSetup(firstWorkerX, firstWorkerY, secondWorkerX, secondWorkerY);
                    EventsBuffer.instance().setLastEventBean(new SetupWorkerDoneEventBean(firstWorkerX, firstWorkerY, secondWorkerX, secondWorkerY, ActionExecutor.instance().getCurrentPlayer().getName()));
                    ActionExecutor.instance().nextTurn();
                } else {
                    EventsBuffer.instance().setLastEventBean(new CommandFailureEventBean("these cells are occupied, reinsert new coordinates"));
                    return;
                }
                if (ActionExecutor.instance().getCurrentPlayer().getFirstWorker() != null &&
                        ActionExecutor.instance().getCurrentPlayer().getSecondWorker() != null &&
                        ActionExecutor.instance().getNextPlayer().getFirstWorker() != null &&
                        ActionExecutor.instance().getNextPlayer().getSecondWorker() != null &&
                        ActionExecutor.instance().getPrevPlayer().getFirstWorker() != null &&
                        ActionExecutor.instance().getPrevPlayer().getSecondWorker() != null) {
                    ActionExecutor.instance().getNextPower().doAction(null);
                }
            }else EventsBuffer.instance().setLastEventBean(new CommandFailureEventBean("can't place workers on the same cells"));

        }else EventsBuffer.instance().setLastEventBean(new CommandFailureEventBean("can't place two worker on the same cells, insert new coordinates"));
    }

    public boolean areCellsOccupied() {
        ActionExecutor actionExecutor = ActionExecutor.instance();
        if (actionExecutor.getMap()[firstWorkerX][firstWorkerY].getWorkerOnCell() == null || actionExecutor.getMap()[secondWorkerX][secondWorkerY] == null)
            return false;
        else
            return true;
    }

    public boolean correctSetUpCoordinatesCheck() {
        if (caratteri.contains((firstWorkerY)) && caratteri.contains( firstWorkerY) && caratteri.contains(( secondWorkerY)) && caratteri.contains( secondWorkerX))
            return true;
        return false;
    }
}

