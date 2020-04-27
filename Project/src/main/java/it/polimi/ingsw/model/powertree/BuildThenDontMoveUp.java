package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Player;

import java.util.List;

public class BuildThenDontMoveUp extends Build {

    private void altComputeInjectionPowerIndex(Player player) {
        List<Power> cachedPowerList = player.getPlayerGod().getPowerList();
        Power injectionPtr;
        Power buildListPtr = player.getPlayerGod().getBuildList().get(0);
        injectionPtr = player.getPlayerGod().getFindAvailableCellsList().get(0);
        int i;

        for (i = 0; cachedPowerList.get(i) != buildListPtr; i++) {
            ;
        }
        player.getPlayerGod().getFindAvailableCellsList().add(i, new FindAvailableCellsMoveButDontMoveUp());
        cachedPowerList.add(i + 1, player.getPlayerGod().getFindAvailableCellsList().get(i)); /* CONTROLLA i+1 */
        //ho aggiornato la list power ma non la FindAvailableCells list;
        player.getPlayerGod().setPowerList(cachedPowerList);
    }

    @Override
    public int doAction(int[] userInput) {

        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]] == getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition()) {

            return 0; /* Il Player ha "costruito" sulla stessa cella del Worker selezionato, ovvero NON vuole costruire */
        }
        altComputeInjectionPowerIndex(getExecutorPointer().getCurrentPlayer());

        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]] == getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition()) {
            PointerBack();
            return -1;
        } else {
            if (super.doAction(userInput) == -1)
                return -1;
        }

        return 0;
    }
}
