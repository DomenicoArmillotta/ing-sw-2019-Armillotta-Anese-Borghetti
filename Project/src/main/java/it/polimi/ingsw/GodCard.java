package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class GodCard {
    private String godName;
    private String description;
    private List<Power> powerList;
    private List<SelectMove> selectMoveList;
    private List<Build> buildList;
    private List<WinCheck> winCheckList;
    private List<FindAvailableCells> findAvailableCellsList;

    public List<Power> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<Power> powerList) {
        this.powerList = powerList;
    }


    public GodCard(String godName, String description) {
        this.godName = godName;
        this.description = description;
        /* Move myMove = new Move();
        moveList.add(myMove);
        moveList.get(0).getOrderNumber();
        powerPointer = moveList.get(0); */
        //powerList.add(new FindAvailableCells());
        //powerList.get(0).doAction();

    }

    public String getGodName() {
        return godName;
    }

    public String getDescription() {
        return description;
    }

    public void setSelectMoveList(List<SelectMove> selectMoveList) {
        this.selectMoveList = selectMoveList;
    }

    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }

    public void setWinCheckList(List<WinCheck> winCheckList) {
        this.winCheckList = winCheckList;
    }

    public void setFindAvailableCellsList(List<FindAvailableCells> findAvailableCellsList) {
        this.findAvailableCellsList = findAvailableCellsList;
    }

    public List<SelectMove> getSelectMoveList() {
        return selectMoveList;
    }

    public List<Build> getBuildList() {
        return buildList;
    }

    public List<WinCheck> getWinCheckList() {
        return winCheckList;
    }

    public List<FindAvailableCells> getFindAvailableCellsList() {
        return findAvailableCellsList;
    }
}
