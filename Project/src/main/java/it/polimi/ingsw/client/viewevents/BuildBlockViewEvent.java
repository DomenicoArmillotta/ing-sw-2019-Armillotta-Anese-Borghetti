package it.polimi.ingsw.client.viewevents;

public class BuildBlockViewEvent extends ViewEvent {
    int blockX;
    int blockY;
    public BuildBlockViewEvent(int blockX, int blockY) {
        this.blockX = blockX;
        this.blockY = blockY;
    }
    public boolean startWaiting() {
        return false;
    }
}
