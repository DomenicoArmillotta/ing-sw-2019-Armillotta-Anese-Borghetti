package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.eventbeans.SetupWorkerDoneEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

public class SetupCoordsEvent extends CoordsEvent {
    int firstWorkerX;
    int firstWorkerY;
    int secondWorkerX;
    int secondWorkerY;

    public SetupCoordsEvent(int firstWorkerX, int firstWorkerY, int secondWorkerX, int secondWorkerY) {
        this.firstWorkerX = firstWorkerX;
        this.firstWorkerY = firstWorkerY;
        this.secondWorkerX = secondWorkerX;
        this.secondWorkerY = secondWorkerY;
    }

    public void serverEventMethod(Controller controller) {
        ActionExecutor.instance().getCurrentPlayer().workersSetup(firstWorkerX, firstWorkerY, secondWorkerX, secondWorkerY);
        EventsBuffer.instance().setLastEventBean(new SetupWorkerDoneEventBean(firstWorkerX, firstWorkerY, secondWorkerX, secondWorkerY, ActionExecutor.instance().getCurrentPlayer().getName()));
        ActionExecutor.instance().nextTurn();
        if(ActionExecutor.instance().getCurrentPlayer().getFirstWorker() != null &&
           ActionExecutor.instance().getCurrentPlayer().getSecondWorker() != null &&
           ActionExecutor.instance().getNextPlayer().getFirstWorker() != null &&
           ActionExecutor.instance().getNextPlayer().getSecondWorker() != null &&
           ActionExecutor.instance().getPrevPlayer().getFirstWorker() != null &&
           ActionExecutor.instance().getPrevPlayer().getSecondWorker() != null) {
            ActionExecutor.instance().getNextPower().doAction(null);
        }
    }
}
