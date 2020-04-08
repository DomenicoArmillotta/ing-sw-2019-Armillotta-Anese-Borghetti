package it.polimi.ingsw;

public class BuildBeforeAndAfterMoveConcrete implements BuildBlockStrategy {
    @Override
    public void buildBlock(int blockX, int blockY, Turn turn) {
        if ((turn.getCurrentPlayer().getPlayerGod().getEffect().getStatus()) && (!(turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).equals(Level.DOME))) {
            Level nextLevel = (turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).getNext();
            turn.getMatch().getCell(blockX, blockY).setBuildingLevel(nextLevel);
        }
    }
}
