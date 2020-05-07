package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.Worker;
import it.polimi.ingsw.model.powertree.Power;

public class WorkerSelectionEvent extends Event {
    Worker selectedWorker;

    public WorkerSelectionEvent(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    private Worker getSelectedWorker() {
        return selectedWorker;
    }

    public void eventMethod() {
        ;
    }
}
