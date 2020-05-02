package it.polimi.ingsw.virtualview;
import it.polimi.ingsw.model.WorkerSelectionEvent;
import it.polimi.ingsw.model.powertree.*;

public class WorkerSelectionListener extends Listener {

    private Select subject;

    @Override
    public void update() {
        WorkerSelectionEvent event = getSubject().getState();
        /* Propago al resto della virtualview */
        Drawer drawer = new Drawer();
        drawer.printWorker(event.getSelectedWorker());
    }

    public Select getSubject() {
        return subject;
    }

    public void setSubject(Select subject) {
        this.subject = subject;
    }
}
