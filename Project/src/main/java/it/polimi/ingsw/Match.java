package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Player> playersOrder;
    private Turn currentTurn;
    private Cell[][] map;
    private GameMaster gameMaster;
    private List<GodCard> godList = new ArrayList<GodCard>();

    public Match(GameMaster gameMaster, List<Player> playersQueue) {
        this.gameMaster = gameMaster;
        this.playersOrder = playersQueue;
        startFirstTurn(playersOrder);
    }

    public Cell getCell(int x, int y)  {
        return map[x][y];
    }

    /*creatore di godList*/

    public void createGodList(){
        GodCard apollo = new GodCard("Apollo");
        Effect effectApollo = new Effect();
        effectApollo.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new MoveSwitchingWorkersConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        godList.add(apollo);

        GodCard artemide = new GodCard("Artemide");
        Effect effectArtemide = new Effect();
        effectArtemide.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new MoveSecondTimeForwardConcrete(), new BasicBuildConcrete());
        godList.add(artemide);

        GodCard athena = new GodCard("Athena");
        Effect effectAthena = new Effect();
        effectAthena.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new MoveCheckingLevelConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        godList.add(athena);

        GodCard atlante = new GodCard("Atlante");
        Effect effectAtlante = new Effect();
        effectAtlante.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new InstantBuildDomeConcrete());
        godList.add(atlante);

        GodCard demetra = new GodCard("Demetra");
        Effect effectDemetra = new Effect();
        effectDemetra.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BuildTwiceDifferentCellConcrete());
        godList.add(demetra);

        GodCard efesto = new GodCard("Efesto");
        Effect effectEfesto = new Effect();
        effectEfesto.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BuildTwiceSameCellConcrete());
        godList.add(efesto);

        GodCard minotauro = new GodCard("Minotauro");
        Effect effectMinotauro = new Effect();
        effectMinotauro.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new MovePushingWorkersConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        godList.add(minotauro);

        GodCard pan = new GodCard("Pan");
        Effect effectPan = new Effect();
        effectPan.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new WinIfTwoLevelsDownConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        godList.add(pan);

        GodCard prometeo = new GodCard("Prometeo");
        Effect effectPrometeo = new Effect();
        effectPrometeo.setEffectStrategies(new SelectBuildOrMoveConcrete(), new MoveButDontMoveUpConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BuildBeforeAndAfterMoveConcrete());
        godList.add(prometeo);
    }


    public GameMaster getGameMaster() {
        return gameMaster;
    }

    public void setPlayersOrder(List<Player> playersQueue) {
        this.playersOrder = playersQueue;
    }

    public List<Player> getPlayersOrder() {
        return playersOrder;
    }

    public void startFirstTurn(List<Player> playersOrder) {
        this.currentTurn = new Turn(this, playersOrder);
    }

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public void createMap() {
        Cell[][] map = new Cell[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = new Cell();
            }
        }
        this.map = map;
    }

    public Cell[][] getMap() {
        return map;
    }
}
