package it.polimi.ingsw;


import java.util.List;

public class ActualTurn {
    private Player player;
    private List<Power> powerList;
    private Power powerPtr;
    private List<Build> buildList;
    private List<SelectMove> selectMoveList;
    private List<FindAvailableCells> findAvailableCellsList;
    private List<WinCheck> winCheckList;


    public Power getNextPower() {
        Power indexPtr = powerList.get(0);
        int index;
        for (index = 0; indexPtr != powerPtr; index++) {
            indexPtr = powerList.get(index);
        }
        this.powerPtr = powerList.get(index + 1);
        return powerPtr;
    }

    public List<Power> getPowerList() {
        return this.powerList;
    }

    public SelectMove getNextSelectMove() {
        return this.selectMoveList.get(0);
    }

    public Build getNextBuild() {
        return this.buildList.get(0);
    }

    public ActualTurn(Player player) {
        this.player = player;
        this.powerList = player.getPlayerGod().getPowerList();
        this.buildList = player.getPlayerGod().getBuildList();
        this.selectMoveList = player.getPlayerGod().getSelectMoveList();
        this.findAvailableCellsList = player.getPlayerGod().getFindAvailableCellsList();
        this.winCheckList = player.getPlayerGod().getWinCheckList();
        powerPtr = powerList.get(0);
    }

    public Player getPlayer() {
        return player;
    }

    public List<Build> getBuildList() {
        return buildList;
    }

    public List<SelectMove> getSelectMoveList() {
        return selectMoveList;
    }

    public List<FindAvailableCells> getFindAvailableCellsList() {
        return findAvailableCellsList;
    }

    public List<WinCheck> getWinCheckList() {
        return winCheckList;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }

    public void setSelectMoveList(List<SelectMove> selectMoveList) {
        this.selectMoveList = selectMoveList;
    }

    public void setFindAvailableCellsList(List<FindAvailableCells> findAvailableCellsList) {
        this.findAvailableCellsList = findAvailableCellsList;
    }

    public void setWinCheckList(List<WinCheck> winCheckList) {
        this.winCheckList = winCheckList;
    }

}
