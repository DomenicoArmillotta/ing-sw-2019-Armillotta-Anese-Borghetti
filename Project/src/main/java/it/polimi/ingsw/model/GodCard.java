package it.polimi.ingsw.model;
import it.polimi.ingsw.model.powertree.*;
import java.util.ArrayList;
import java.util.List;

public class GodCard {
    private String godName;
    private String description;
    private List<Power> powerList;
    private List<Select> selectList;
    private List<Move> moveList;
    private List<Build> buildList;
    private List<WinCondition> winCheckList;
    private List<FindAvailableCells> findAvailableCellsList;

    public void setupLists() {
        List<Select> selectList = new ArrayList<>();
        List<Move> moveList = new ArrayList<>();
        List<Build> buildList = new ArrayList<>();
        List<WinCondition> winCheckList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
    }

    public List<Power> getPowerList() {
        return powerList;
    }

    public List<Select> getSelectList() {
        return selectList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public List<Build> getBuildList() {
        return buildList;
    }

    public List<WinCondition> getWinConditionList() {
        return winCheckList;
    }

    public List<FindAvailableCells> getFindAvailableCellsList() {
        return findAvailableCellsList;
    }

    public void setFindAvailableCellsList(List<FindAvailableCells> findAvailableCellsList) {
        this.findAvailableCellsList = findAvailableCellsList;
    }

    public void setSelectList(List<Select> selectList) {
        this.selectList = selectList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }

    public void setWinConditionList(List<WinCondition> winConditionList) {
        this.winCheckList = winCheckList;
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
    /*
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
    */
}
