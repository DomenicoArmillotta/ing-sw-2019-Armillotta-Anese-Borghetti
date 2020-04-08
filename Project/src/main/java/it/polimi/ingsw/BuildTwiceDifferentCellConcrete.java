package it.polimi.ingsw;

public class BuildTwiceDifferentCellConcrete implements BuildBlockStrategy {
    @Override
    public void buildBlock(int blockX, int blockY, Turn turn) {
        if (!(turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).equals(Level.DOME)) {
            Level nextLevel = (turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).getNext();
            turn.getMatch().getCell(blockX, blockY).setBuildingLevel(nextLevel);
        }
        /* need another strategy for the second build*/
    }
}
