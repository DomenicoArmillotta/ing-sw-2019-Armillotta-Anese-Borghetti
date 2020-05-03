package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.model.WaitingForEvent;
import it.polimi.ingsw.model.WorkerMovementEvent;
import it.polimi.ingsw.model.powertree.FindAvailableCells;
import it.polimi.ingsw.model.powertree.Move;

public class WaitingForEventListener extends Listener {

    private FindAvailableCells subject;

    @Override
    public void update() {
        WaitingForEvent event = getSubject().getState();
        System.out.println(ANSI_GREEN + event.getAvailableCells().size() + ANSI_RESET + " cells are available, " + ANSI_YELLOW + "waiting for next action..." + ANSI_RESET + " (" + event.getNextPower() + ")");
        /* Propago al resto della virtualview */
        /* Drawer drawer = new Drawer();
        drawer.printWorker(event.getSelectedWorker()); */
    }

    public FindAvailableCells getSubject() {
        return subject;
    }

    public void setSubject(FindAvailableCells subject) {
        this.subject = subject;
    }
}
