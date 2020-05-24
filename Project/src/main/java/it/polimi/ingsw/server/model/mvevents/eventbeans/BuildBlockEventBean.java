package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class BuildBlockEventBean extends EventBean {
    int levelToBuild;
    int blockX;
    int blockY;

    public void setBlockX(int blockX) {
        this.blockX = blockX;
    }

    public void setBlockY(int blockY) {
        this.blockY = blockY;
    }

    public int getBlockX() {
        return blockX;
    }

    public int getBlockY() {
        return blockY;
    }

    public int getLevelToBuild() {
        return levelToBuild;
    }

    public void setLevelToBuild(int levelToBuild) {
        this.levelToBuild = levelToBuild;
    }

    public BuildBlockEventBean(int blockX, int blockY,int levelToBuild){
       this.blockX = blockX;
       this.blockY = blockY;
       this.levelToBuild = levelToBuild;
    }

}
