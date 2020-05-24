package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class SetupWorkerDoneEventBean extends EventBean {

    int x;
    int y;
    int z;
    int w;
    String ownerName;

    public SetupWorkerDoneEventBean(int x, int y, int z, int w, String ownerName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getW() {
        return w;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setW(int w) {
        this.w = w;
    }
}
