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

    public int doAction(int[] userInput) { /* Overridden in subclasses */
        /* No action */
        return -1; /* Action failed: this method should be called from Power subclasses */
    }

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

    public void clearPower() {
        /* Nothing to clean */
    }

    protected int getWorkerIndex() {
        if(getExecutorPointer().getPrevSelect().getSelectedWorker().equals(getExecutorPointer().getCurrentPlayer().getFirstWorker())) {
            return 0;
        } return 1;
    }

}
