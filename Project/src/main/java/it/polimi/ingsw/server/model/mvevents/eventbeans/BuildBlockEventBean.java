package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class BuildBlockEventBean extends EventBean {
    String eventType;
    int blockX;
    int blockY;

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setBlockX(int blockX) {
        this.blockX = blockX;
    }

    public void setBlockY(int blockY) {
        this.blockY = blockY;
    }

    public String getEventType() {
        return eventType;
    }

    public int getBlockX() {
        return blockX;
    }

    public int getBlockY() {
        return blockY;
    }

    public BuildBlockEventBean(int blockX, int blockY){
       eventType = "BuildBlockEvent";
       this.blockX = blockX;
       this.blockY = blockY;
    }
}
