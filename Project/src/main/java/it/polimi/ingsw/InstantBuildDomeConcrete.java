package it.polimi.ingsw;

public class InstantBuildDomeConcrete implements BuildBlockStrategy {
    @Override
    public void doBuildBlock(Cell selectedCell) {
        selectedCell.setBuildingLevel(Level.DOME);
    }
}
