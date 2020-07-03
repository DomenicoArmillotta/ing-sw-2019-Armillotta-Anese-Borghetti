package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.virtualview.listeners.*;

public abstract class Power {

    /* Every Power can reach Map, Players, GodCards and other Powers through executorPointer */
    protected ActionExecutor executorPointer = ActionExecutor.instance(); /* Singleton ActionExecutor */

    /* private Event lastEvent; */


    private WorkerSelectionListener workerSelectionListener = WorkerSelectionListener.instance();
    private WaitingForActionListener waitingForActionListener = WaitingForActionListener.instance();
    private WorkerMovementListener workerMovementListener = WorkerMovementListener.instance();
    private BuildBlockListener buildBlockListener = BuildBlockListener.instance();
    private PlayerWonListener playerWonListener = PlayerWonListener.instance();
    private PlayerLostListener playerLostListener = PlayerLostListener.instance();
    private FailedActionListener failedActionListener = FailedActionListener.instance();
    private NoUpdatesListener noUpdatesListener = NoUpdatesListener.instance();
    private BooleanActionListener booleanActionListener = BooleanActionListener.instance();

    public BooleanActionListener getBooleanActionListener() {
        return booleanActionListener;
    }

    public WorkerSelectionListener getWorkerSelectionListener() {
        return workerSelectionListener;
    }

    public WaitingForActionListener getWaitingForActionListener() {
        return waitingForActionListener;
    }

    public WorkerMovementListener getWorkerMovementListener() {
        return workerMovementListener;
    }

    public BuildBlockListener getBuildBlockListener() {
        return buildBlockListener;
    }

    public PlayerWonListener getPlayerWonListener() {
        return playerWonListener;
    }

    public PlayerLostListener getPlayerLostListener() {
        return playerLostListener;
    }

    public FailedActionListener getFailedActionListener() {
        return failedActionListener;
    }

    public NoUpdatesListener getNoUpdatesListener() {
        return noUpdatesListener;
    }

    public ActionExecutor getExecutorPointer() {
        return executorPointer;
    }

    /**
     * function that take @param as input and return 3 different values 0, 1 , -1; the action is succesfully executed and the model
     * need
     * @param userInput userInput from the cli or gui
     * @return -1 action failed 0 if was successful
     */
    /*
    set abstract;
     */
    public int doAction(int[] userInput) { /* Overridden in subclasses */
        /* No action */
       return -1;/* Action failed: this method should be called from Power subclasses */
    }

    /**
     * when a doAction() fails, pointerBack reset the pointer to the same action that failed
     * @return 0 if successful, -1 if failed;
     */
    public int pointerBack() {
        int index;
        Power powerPtr = executorPointer.getPowerPtr();
        if (powerPtr != null) {
            Power indextPtr = executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(0);
            for (index = 0; indextPtr != powerPtr; index++) {
                indextPtr = executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(index);
            }
            executorPointer.setPowerPtr(executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(index - 2));
            return 0;
        } else {
            return -1;
        }
    }
        //*refactor
    public void clearPower(){

    }
        /* Nothing to clean */

    /**
     * Method that return the index of AvailableCells for the last selected worker
     * @return 0 if is the first, 1 if is the second
     */
    protected int getWorkerIndex() {
        if(getExecutorPointer().getPrevSelect().getSelectedWorker().equals(getExecutorPointer().getCurrentPlayer().getFirstWorker())) {
            return 0;
        } return 1;
    }

}
