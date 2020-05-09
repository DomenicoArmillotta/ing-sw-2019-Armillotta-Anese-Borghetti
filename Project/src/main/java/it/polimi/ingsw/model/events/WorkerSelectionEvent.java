package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.Worker;
import it.polimi.ingsw.model.powertree.Power;

import java.io.Serializable;

public class WorkerSelectionEvent extends Event implements Serializable {
    private Worker selectedWorker;

    public WorkerSelectionEvent(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    private Worker getSelectedWorker() {
        return selectedWorker;
    }

    public void eventMethod() {
        System.out.println("Selected "+selectedWorker.getCurrentPosition().getX()+" "+selectedWorker.getCurrentPosition().getY()+" selected");
    }
}
