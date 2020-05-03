package it.polimi.ingsw.model;

import it.polimi.ingsw.model.powertree.Power;

public class WorkerSelectionEvent implements Event { /* entro automaticamente in WAITING FOR MOVE */
    Worker selectedWorker;
    Power nextPower;

    public WorkerSelectionEvent(Worker selectedWorker, Power nextPower) {
        this.selectedWorker = selectedWorker;
        this.nextPower = nextPower;
    }

    public Worker getSelectedWorker() {
        return selectedWorker;
    }

    public Power getNextPower() {
        return nextPower;
    }
}
