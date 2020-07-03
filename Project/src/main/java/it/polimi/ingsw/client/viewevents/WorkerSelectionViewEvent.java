package it.polimi.ingsw.client.viewevents;
import it.polimi.ingsw.client.proxymodel.*;
import java.util.ArrayList;
import java.util.List;

/**
 * highlight selectable workers
 */
public class WorkerSelectionViewEvent extends ViewEvent {
    int workerX;
    int workerY;
    ProxyModel proxyModel = ProxyModel.instance();

    public WorkerSelectionViewEvent(int workerX, int workerY) {
        this.workerX = workerX;
        this.workerY = workerY;
    }

    /**
     * draw the quarter to highlight selectable workers
     */
    public void viewEventMethod() {
        List<Coords> coordsList = new ArrayList<>();
        coordsList.add(new Coords(workerX, workerY));
        proxyModel.getMap()[workerX][workerY].getWorker().select();
        proxyModel.getDrawerStrategy().promptMovementText();

    }
}
