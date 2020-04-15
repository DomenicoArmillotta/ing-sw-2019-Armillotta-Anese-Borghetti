package it.polimi.ingsw;

public class BasicBuildBlockConcrete implements BuildBlockStrategy {
    @Override
    public void doBuildBlock(Cell selectedCell) {
        Level nextLevel = selectedCell.getBuildingLevel().getNext();
        selectedCell.setBuildingLevel(nextLevel);
        /*if (!(turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).equals(Level.DOME)) {
            Level nextLevel = (turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).getNext();
            turn.getMatch().getCell(blockX, blockY).setBuildingLevel(nextLevel);
        } */
        ;
    }
}