package it.polimi.ingsw;

import java.util.*;

public class GameMaster {
    private List<Player> playerQueue; //da controllora sinstassi
    private int numOfPlayers;
    private ActionExecutor actionExecutor;
    private List<GodCard> godList;

    public GameMaster(int numOfPlayers, List<Player> playerQueue) {
        this.numOfPlayers = numOfPlayers;
        this.playerQueue = playerQueue;
    }

    public void createActionExecutor() {
        this.actionExecutor = ActionExecutor.instance();
        if (numOfPlayers == 2) {
            this.actionExecutor.setCurrentActualTurn(new ActualTurn(playerQueue.get(0)));
            this.actionExecutor.setNextActualTurn(new ActualTurn(playerQueue.get(1)));
            this.actionExecutor.setPrevActualTurn(new ActualTurn(playerQueue.get(1)));
        } else if (numOfPlayers == 3) {
            this.actionExecutor.setCurrentActualTurn(new ActualTurn(playerQueue.get(0)));
            this.actionExecutor.setNextActualTurn(new ActualTurn(playerQueue.get(1)));
            this.actionExecutor.setPrevActualTurn(new ActualTurn(playerQueue.get(2)));
        }
    }

    public ActionExecutor getActionExecutor() {
        return this.actionExecutor;
    }

    public int getNumOfPlayers() {
        return this.numOfPlayers;
    }

    public List<Player> getPlayerQueue() {
        return playerQueue;
    }

    public List<GodCard> getGodList() {
        return godList;
    }

    public void createGodList() {
        List<GodCard> godList = new ArrayList<>();
        GodCard apollo = new GodCard("Apollo", "Dio della Musica");
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSwitchSelect());
        findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBasicBuild());
        apollo.setFindAvailableCellsList(findAvailableCellsList);
        List<SelectMove> selectMoveList = new ArrayList<>();
        selectMoveList.add(new Select());
        selectMoveList.add(new Switch());
        apollo.setSelectMoveList(selectMoveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        apollo.setBuildList(buildList);
        List<WinCheck> winCheckList = new ArrayList<>();
        apollo.setWinCheckList(winCheckList);
        List<Power> powerList = new ArrayList<>();
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectMoveList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(selectMoveList.get(1));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        apollo.setPowerList(powerList);
        godList.add(apollo);
        this.godList = godList;

        /*int[] input = new int[10];

        if (powerList.get(0) == selectMoveList.get(0)) {
            powerList.get(0).doAction(input);
        }*/

        /* GodCard apollo = new GodCard("Apollo", "Dio della Musica");
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSwitchSelect());
        findAvailableCellsList.add(new FindAvailableCellsSwitchMove());
        findAvailableCellsList.add(new FindAvailableCellsBasicBuild());
        apollo.setFindAvailableCellsList(findAvailableCellsList);
        List<SelectMove> selectMoveList = new ArrayList<>();
        selectMoveList.add(new Select());
        selectMoveList.add(new Switch());
        apollo.setSelectMoveList(selectMoveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        apollo.setBuildList(buildList);
        List<WinCheck> winCheckList = new ArrayList<>();
        apollo.setWinCheckList(winCheckList); */


    }

}
