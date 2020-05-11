package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.WorkerSelectionEventBean;

import java.io.Serializable;

public class WorkerSelectionEvent extends ActionEvent implements Serializable {
    private Worker selectedWorker;

    public WorkerSelectionEvent(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    private Worker getSelectedWorker() {
        return selectedWorker;
    }

    public EventBean eventMethod() {
        WorkerSelectionEventBean workerSelectionEventBean = new WorkerSelectionEventBean(getSelectedWorker().getCurrentPosition().getX(), getSelectedWorker().getCurrentPosition().getY());
        return workerSelectionEventBean;
    }
}
