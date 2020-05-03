package it.polimi.ingsw.virtualview;
import it.polimi.ingsw.model.WorkerSelectionEvent;
import it.polimi.ingsw.model.powertree.*;


public class WorkerSelectionListener extends Listener {

    private Select subject;

    @Override
    public void update() {
        WorkerSelectionEvent event = getSubject().getState();
        /* Propago al resto della virtualview */
        /* Drawer drawer = new Drawer();
        drawer.printWorker(event.getSelectedWorker()); */
        System.out.println("Selected " + ANSI_BLUE + event.getSelectedWorker() + ANSI_RESET + ", " + ANSI_YELLOW + "waiting for next action..." + ANSI_RESET + " (" + event.getNextPower() + ")");
    }

    public Select getSubject() {
        return subject;
    }

    public void setSubject(Select subject) {
        this.subject = subject;
    }
}
