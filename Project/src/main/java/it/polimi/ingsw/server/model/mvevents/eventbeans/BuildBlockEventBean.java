package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class BuildBlockEventBean extends EventBean {
    String eventType;
    int blockX;
    int blockY;

    public BuildBlockEventBean(int blockX, int blockY){
       eventType = "BuildBlockEvent";
       this.blockX = blockX;
       this.blockY = blockY;
    }
}
