package it.polimi.ingsw;


import java.util.List;

public class ActualTurn {
    private Player player;
    private List<Build> buildList;
    private List<SelectMove> selectMoveList;
    private List<FindAvailableCells> findAvailableCellsList;
    private List<WinCheck> winCheckList;

    public ActualTurn(Player player, List<Build> buildList, List<SelectMove> selectMoveList, List<FindAvailableCells> findAvailableCellsList, List<WinCheck> winCheckList) {
        this.player = player;
        this.buildList = buildList;
        this.selectMoveList = selectMoveList;
        this.findAvailableCellsList = findAvailableCellsList;
        this.winCheckList = winCheckList;
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
