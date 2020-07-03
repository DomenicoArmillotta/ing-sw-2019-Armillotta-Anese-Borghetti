package it.polimi.ingsw.client.proxymodel;

/**
 * ClientCell represent the model's cell without the server's logic
 */

public class ClientCell {
    private Coords cellCoords;
    private int selectable;//0 per i selectable
    private int workerSelectable;
    private WorkerClient worker;
    private WorkerClient underWorker;
    private int level; //1,2,3,4 per i livelli
    private int border;

    /**
     * getUnderWorker returns the worker which is on this cell under another worker
     * @return the said WorkerClient
     */

    public WorkerClient getUnderWorker() {
        return underWorker;
    }

    /**
     * getUnderWorker place a worker on this cell, under another worker
     * @param underWorker the worker that is under
     */
    public void setUnderWorker(WorkerClient underWorker) {
        this.underWorker = underWorker;
    }


    public void setCellCoords(Coords cellCoords) {
        this.cellCoords = cellCoords;
    }

    /**
     * setSelectable sets if this cell is selectable by the user (for a selection, movement or build) or not
     * @param selectable the selectable
     */
    public void setSelectable(int selectable) {
        this.selectable = selectable;
    }

    /**
     * getworkerSelectable specifies if the worker that is on this cell is selectable or not during the selection phase
     * @return workerSelectable the selectable worker
     */
    public int getworkerSelectable() {
        return workerSelectable;
    }

    /**
     * getworkerSelectable sets if the worker that is on this cell is selectable or not during the selection phase
     * @param workerSelectable  worker selected
     */
    public void setworkerSelectable(int workerSelectable) {
        this.workerSelectable = workerSelectable;
    }

    /**
     * setLevel sets this cell's building level
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /* not used */

    public void setBorder(int border) {
        this.border = border;
    }

    /**
     * getCellCoords returns the coordinates of this cell
     * @return the said Coords
     */
    public Coords getCellCoords() {
        return cellCoords;
    }

    /**
     * getSelectable return an integer value that specifies if this cell is selectable or not
     * @return the said value
     */

    public int getSelectable() {
        return selectable;
    }

    /**
     * getWorker returns the worker that is on this cell
     * @return the said WorkerClient
     */

    public WorkerClient getWorker() {
        return worker;
    }

    /**
     * setWorker is used to place a worker on this cell
     * @param worker the worker
     */

    public void setWorker(WorkerClient worker) {
        this.worker = worker;
    }

    /**
     * getLevel gets this cell's building level
     * @return level the level
     */

    public int getLevel() {
        return level;
    }

    /* not used */

    public int getBorder() {
        return border;
    }
}
