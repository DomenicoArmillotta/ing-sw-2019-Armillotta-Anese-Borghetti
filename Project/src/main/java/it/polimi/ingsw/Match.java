package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Player> playersOrder;
    private Turn currentTurn;
    private Cell[][] map;
    private GameMaster gameMaster;
    private List<GodCard> godList = new ArrayList();

    public Match(GameMaster gameMaster, List<Player> playersQueue) {
        this.gameMaster = gameMaster;
        this.playersOrder = playersQueue;
    }

    public void createMap() {
        Cell[][] map = new Cell[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = new Cell();
                map[i][j].setX(j);
                map[i][j].setY(i);
            }
        }
        this.map = map;
    }

    public Cell[][] getMap() {
        return map;
    }

    public Cell getCell(int x, int y) {
        return map[x][y];
    }

    /*creatore di godList*/

    public void createGodList() {
        GodCard apollo = new GodCard("Apollo", "bla bla");
        Effect effectApollo = new Effect();
        apollo.setEffect(effectApollo);
        effectApollo.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new MoveSwitchingWorkersConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        this.godList.add(apollo);

        GodCard artemide = new GodCard("Artemide","bla bla");
        Effect effectArtemide = new Effect();
        artemide.setEffect(effectArtemide);
        effectArtemide.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new MoveSecondTimeForwardConcrete(), new BasicBuildConcrete());
        godList.add(artemide);

        GodCard athena = new GodCard("Athena","bla bla");
        Effect effectAthena = new Effect();
        athena.setEffect(effectAthena);
        effectAthena.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new MoveCheckingLevelConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        godList.add(athena);

        GodCard atlante = new GodCard("Atlante","bla bla");
        Effect effectAtlante = new Effect();
        atlante.setEffect(effectAtlante);
        effectAtlante.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new InstantBuildDomeConcrete());
        godList.add(atlante);

        GodCard demetra = new GodCard("Demetra","bla bla");
        Effect effectDemetra = new Effect();
        demetra.setEffect(effectDemetra);
        effectDemetra.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BuildTwiceDifferentCellConcrete());
        godList.add(demetra);

        GodCard efesto = new GodCard("Efesto","bla bla");
        Effect effectEfesto = new Effect();
        efesto.setEffect(effectEfesto);
        effectEfesto.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BuildTwiceSameCellConcrete());
        godList.add(efesto);

        GodCard minotauro = new GodCard("Minotauro","bla bla");
        Effect effectMinotauro = new Effect();
        minotauro.setEffect(effectMinotauro);
        effectMinotauro.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new MovePushingWorkersConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        godList.add(minotauro);

        GodCard pan = new GodCard("Pan","bla bla");
        Effect effectPan = new Effect();
        pan.setEffect(effectPan);
        effectPan.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new BasicMoveConcrete(),
                new WinIfTwoLevelsDownConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
        godList.add(pan);

        GodCard prometeo = new GodCard("Prometeo", "bla bla");
        Effect effectPrometeo = new Effect();
        prometeo.setEffect(effectPrometeo);
        effectPrometeo.setEffectStrategies(new SelectBuildOrMoveConcrete(), new MoveButDontMoveUpConcrete(), new BasicMoveConcrete(),
                new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BuildBeforeAndAfterMoveConcrete());
        godList.add(prometeo);
    }

    public List<GodCard> getGodList() {
        return godList;
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

}
