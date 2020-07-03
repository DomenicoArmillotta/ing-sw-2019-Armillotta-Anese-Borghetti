package it.polimi.ingsw.server.model.powertree;

public class SelectThenSkip extends Select {
    /**
     * select then skips the next action
     * @param userInput the integer coordinates of the Worker to be selected
     * @return 1 if super.doAction() was successful else -1 for a failedAction
     */
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(userInput) == 0)
            return 1;
        return  -1;
    }
}
