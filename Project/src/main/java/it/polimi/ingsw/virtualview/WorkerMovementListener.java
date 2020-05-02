package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.model.WorkerMovementEvent;
import it.polimi.ingsw.model.WorkerSelectionEvent;
import it.polimi.ingsw.model.powertree.Move;

public class WorkerMovementListener extends Listener {

    private Move subject;

    @Override
    public void update() {
        WorkerMovementEvent event = getSubject().getState();
        /* Propago al resto della virtualview */
        Drawer drawer = new Drawer();
        drawer.printWorker(event.getSelectedWorker());
    }

    public Move getSubject() {
        return subject;
    }

    public void setSubject(Move subject) {
        this.subject = subject;
    }
}
