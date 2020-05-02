package it.polimi.ingsw.model;

public class WorkerSelectionEvent implements Event {
    Worker selectedWorker;

    public WorkerSelectionEvent(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    public Worker getSelectedWorker() {
        return selectedWorker;
    }
}
