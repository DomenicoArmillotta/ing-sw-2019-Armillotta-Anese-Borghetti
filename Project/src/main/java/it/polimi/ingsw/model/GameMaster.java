package it.polimi.ingsw.model;

import it.polimi.ingsw.model.powertree.*;

import java.util.ArrayList;
import java.util.List;

public class GameMaster {

    private List<Player> playerQueue;
    private int numOfPlayers;
    private ActionExecutor actionExecutor;
    private List<GodCard> godCards;

    public GameMaster(List<Player> playerQueue, int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        this.playerQueue = playerQueue;
        createGodList();
        createActionExecutor();
        getActionExecutor().cleanActionExecutor();
    }

    public void createActionExecutor() {
        this.actionExecutor = ActionExecutor.instance();
        if (numOfPlayers == 2) {
            for (int i = 0; i < 2; i++) {
                /* GodCard is Mortal by default for every Player, then it can be changed */
                playerQueue.get(i).setPlayerGod(getGodList().get(God.MORTAL.ordinal()));
            }
            this.actionExecutor.setCurrentPlayer(playerQueue.get(0));
            this.actionExecutor.setNextPlayer(playerQueue.get(1));
            this.actionExecutor.setPrevPlayer(playerQueue.get(1));
        } else if (numOfPlayers == 3) {
            for (int i = 0; i < 3; i++) {
                /* GodCard is Mortal by default for every Player, then it can be changed */
                playerQueue.get(i).setPlayerGod(getGodList().get(God.MORTAL.ordinal()));
            }
            this.actionExecutor.setCurrentPlayer(playerQueue.get(0));
            this.actionExecutor.setNextPlayer(playerQueue.get(1));
            this.actionExecutor.setPrevPlayer(playerQueue.get(2));
        }
    }

    public ActionExecutor getActionExecutor() {
        return this.actionExecutor;
    }

    public int getNumOfPlayers() {
        return this.numOfPlayers;
    }

    public List<GodCard> getGodList() {
        return godCards;
    }

    public void createGodList() {
        List<GodCard> godCards = new ArrayList<>();
        godCards.add(createMortalCard());
        godCards.add(createApolloCard());
        godCards.add(createArtemisCard());
        godCards.add(createAthenaCard());
        godCards.add(createAtlasCard());
        godCards.add(createDemeterCard());
        godCards.add(createHephaestusCard());
        godCards.add(createMinotaurCard());
        godCards.add(createPanCard());
        godCards.add(createPrometheusCard());
        this.godCards = godCards;
    }

    private GodCard createMortalCard() {
        GodCard mortalCard = new GodCard("Mortal", "Human being");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsMove());
        //findAvailableCellsList.add(new FindAvailableCellsMoveButDontMoveUp());
        //findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        mortalCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        mortalCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        mortalCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        mortalCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        mortalCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        //powerList.add(findAvailableCellsList.get(1));
        powerList.add(selectList.get(0));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(buildList.get(0));
        mortalCard.setPowerList(powerList);
        return mortalCard;
    }

    private GodCard createApolloCard() {
        GodCard apolloCard = new GodCard("Apollo", "God of Music");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelectSwitch());
        findAvailableCellsList.add(new FindAvailableCellsMoveSwitch());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        apolloCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        apolloCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new MoveSwitch());
        apolloCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        apolloCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        apolloCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        apolloCard.setPowerList(powerList);
        return apolloCard;
    }

    private GodCard createArtemisCard() {
        GodCard artemisCard = new GodCard("Artemis", "Goddess of the Hunt");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelect());
        findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        artemisCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        artemisCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        artemisCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        artemisCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        artemisCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        artemisCard.setPowerList(powerList);
        return artemisCard;
    }

    private GodCard createAthenaCard() {
        GodCard athenaCard = new GodCard("Athena", "Goddess of Wisdom");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelect());
        findAvailableCellsList.add(new FindAvailableCellsMoveButDontMoveUp());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        athenaCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        athenaCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        athenaCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        athenaCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        athenaCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        athenaCard.setPowerList(powerList);
        return athenaCard;
    }

    private GodCard createAtlasCard() {
        GodCard atlasCard = new GodCard("Atlas", "Titan Shouldering the Heavens");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelect());
        findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        atlasCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        atlasCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        atlasCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new InstantBuildDome());
        atlasCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        atlasCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        atlasCard.setPowerList(powerList);
        return atlasCard;
    }

    private GodCard createDemeterCard() {
        GodCard demeterCard = new GodCard("Demeter", "Goddess of the Harvest");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelectMove());
        //findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        demeterCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        demeterCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        demeterCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        demeterCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        demeterCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        //powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(buildList.get(0));
        demeterCard.setPowerList(powerList);
        return demeterCard;
    }

    private GodCard createHephaestusCard() {
        GodCard hephaestusCard = new GodCard("Hephaestus", "God of Blacksmiths");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelect());
        findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        hephaestusCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        hephaestusCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        hephaestusCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new DontBuildDome());
        hephaestusCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        hephaestusCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        hephaestusCard.setPowerList(powerList);
        return hephaestusCard;
    }

    private GodCard createMinotaurCard() {
        GodCard minotaurCard = new GodCard("Minotaur", "Bull-headed Monster");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelectPush());
        findAvailableCellsList.add(new FindAvailableCellsMovePush());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        minotaurCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        minotaurCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new MovePush());
        minotaurCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        minotaurCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        minotaurCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        minotaurCard.setPowerList(powerList);
        return minotaurCard;
    }

    private GodCard createPanCard() {
        GodCard panCard = new GodCard("Pan", "God of the Wild");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelect());
        findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        panCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        panCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        panCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        panCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinIfTwoLevelsDown());
        panCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        panCard.setPowerList(powerList);
        return panCard;
    }

    private GodCard createPrometheusCard() {
        GodCard prometheusCard = new GodCard("Prometheus", "Titan Benefactor of Mankind");
        List<Power> powerList = new ArrayList<>();
        List<FindAvailableCells> findAvailableCellsList = new ArrayList<>();
        findAvailableCellsList.add(new FindAvailableCellsSelect());
        findAvailableCellsList.add(new FindAvailableCellsMove());
        findAvailableCellsList.add(new FindAvailableCellsBuild());
        prometheusCard.setFindAvailableCellsList(findAvailableCellsList);
        List<Select> selectList = new ArrayList<>();
        selectList.add(new Select());
        prometheusCard.setSelectList(selectList);
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move());
        prometheusCard.setMoveList(moveList);
        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build());
        prometheusCard.setBuildList(buildList);
        List<WinCondition> winConditionList = new ArrayList<>();
        winConditionList.add(new WinCondition());
        prometheusCard.setWinConditionList(winConditionList);
        powerList.add(findAvailableCellsList.get(0));
        powerList.add(selectList.get(0));
        powerList.add(findAvailableCellsList.get(1));
        powerList.add(moveList.get(0));
        powerList.add(winConditionList.get(0));
        powerList.add(findAvailableCellsList.get(2));
        powerList.add(buildList.get(0));
        prometheusCard.setPowerList(powerList);
        return prometheusCard;
    }

}
