package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.WorkerMovementEventBean;

public class WorkerMovementEvent extends ActionEvent {
    Worker movedWorker;

    public WorkerMovementEvent(Worker movedWorker) {
        this.movedWorker = movedWorker;
    }

    private Worker getSelectedWorker() {
        return movedWorker;
    }

    public EventBean eventMethod() {
        WorkerMovementEventBean workerMovementEventBean = new WorkerMovementEventBean(getSelectedWorker().getPreviousPosition().getX(), getSelectedWorker().getPreviousPosition().getY(),
                                                                                      getSelectedWorker().getCurrentPosition().getX(), getSelectedWorker().getCurrentPosition().getY());
        return workerMovementEventBean;
    }
}
