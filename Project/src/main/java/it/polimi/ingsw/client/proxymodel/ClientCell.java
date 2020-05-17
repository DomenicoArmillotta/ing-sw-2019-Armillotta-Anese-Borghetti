package it.polimi.ingsw.client.proxymodel;

public class ClientCell {
    private Coords cellCoords;
    private int selectable;//0 per i selectable
    private WorkerClient worker;
    private int level; //1,2,3,4 per i livelli
    private int border;

    public void setCellCoords(Coords cellCoords) {
        this.cellCoords = cellCoords;
    }

    public void setSelectable(int selectable) {
        this.selectable = selectable;
    }



    public void setLevel(int level) {
        this.level = level;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public Coords getCellCoords() {
        return cellCoords;
    }

    public int getSelectable() {
        return selectable;
    }

    public WorkerClient getWorker() {
        return worker;
    }

    public void setWorker(WorkerClient worker) {
        this.worker = worker;
    }

    public int getLevel() {
        return level;
    }

    public int getBorder() {
        return border;
    }
}
