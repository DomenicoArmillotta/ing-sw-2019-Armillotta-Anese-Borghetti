package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.model.BuildBlockEvent;
import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.WorkerMovementEvent;
import it.polimi.ingsw.model.powertree.Build;
import it.polimi.ingsw.model.powertree.Move;
import it.polimi.ingsw.model.powertree.Power;

public class BuildBlockListener extends Listener {

    private Build subject;

    @Override
    public void update() {
        BuildBlockEvent event = getSubject().getState();
        /* Propago al resto della virtualview */
        /* Drawer drawer = new Drawer();
        drawer.printWorker(event.getSelectedWorker()); */
        System.out.println("Built block on " + ANSI_BLUE + event.getCellWithBlock() + ANSI_RESET);
        System.out.println();

    }

    public Build getSubject() {
        return subject;
    }

    public void setSubject(Build subject) {
        this.subject = subject;
    }

}
