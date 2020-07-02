package it.polimi.ingsw.server.model.godcards;
import it.polimi.ingsw.server.model.powertree.*;
import java.util.ArrayList;
import java.util.List;

/**
 * this class contains all the attributes useful to completely characterize a god.
 * godName contains the name of the god, Description contain a brief descriptions of his power
 * powerList contains is a list of power that aa particular god can execute
 * selectList contain all the powers regarding the process of selection of a worker
 * moveList contains all the power regarding the ability of movement of this god
 * BuildList contains all the powers regarding the type of build of this god
 * WinConditions contains all the powers used for checking if a player won
 * findAvailableCells list contains all the powers regarding the selection of cell available for constructing and moving
 * moveLimitationsList contains all the move limitations that other gods can add to this god
 * booleanRequestStrategy contains the powers regarding boolean choice
 *
 */
public class GodCard {
    private String godName;
    private String description;
    private List<Power> powerList;
    private List<Select> selectList;
    private List<Move> moveList;
    private List<Build> buildList;
    private List<WinCondition> winCheckList;
    private List<FindAvailableCells> findAvailableCellsList;
    private List<FindAvailableCells> moveLimitationsList;
    private BooleanRequestAction booleanRequestActionStrategy;


    public void setGodName(String godName) {
        this.godName = godName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWinCheckList(List<WinCondition> winCheckList) {
        this.winCheckList = winCheckList;
    }

    public List<FindAvailableCells> getMoveLimitationsList() {
        return moveLimitationsList;
    }

    public void addMoveLimitations(FindAvailableCells moveLimitationsList) {
        this.moveLimitationsList.add(moveLimitationsList);
    }

    public GodCard() {
        List<FindAvailableCells> moveLimitationsList = new ArrayList<>();
        this.moveLimitationsList = moveLimitationsList;
    }

    /**
     * setup a list of powers for a particular god
     */
    public void setupLists() {
        List<Select> selectList = new ArrayList<>();
        this.selectList = selectList;
        List<Move> moveList = new ArrayList<>();
        this.moveList = moveList;
        List<Build> buildList = new ArrayList<>();
        this.buildList = buildList;
        List<WinCondition> winCheckList = new ArrayList<>();
        this.winCheckList = winCheckList;
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        this.findAvailableCellsList = findAvailableCellsList;
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
    }

    public BooleanRequestAction getBooleanRequestActionStrategy() {
        return booleanRequestActionStrategy;
    }

    /**
     * set a particular booleanRequestActionStrategy
     * @param booleanRequestActionStrategy
     */
    public void setBooleanRequestActionStrategy(BooleanRequestAction booleanRequestActionStrategy){
        this.booleanRequestActionStrategy = booleanRequestActionStrategy;
    }

    public String getGodName() {
        return godName;
    }

    public String getDescription() {
        return description;
    }

}
