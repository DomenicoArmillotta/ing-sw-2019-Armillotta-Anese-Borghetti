package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EffectTest {
    @Test
    public void EffectTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();

        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();

        GodCard apollo = new GodCard("Apollo", "bla bla");
        Effect effectApollo = new Effect();
        apollo.setEffect(effectApollo);
        effectApollo.setEffectStrategies(new BasicReturnSelectOptionsConcrete(), new NoSubtractSelectRestraintsConcrete(), new BasicSelectWorkerConcrete(),
                new BasicReturnBuildOptionsConcrete(), new BasicBuildBlockConcrete(), new BasicReturnMoveOptions(),
                new NoSubtractMoveRestraintsConcrete(), new BasicMoveWorkerConcrete(), new BasicReturnMoveOptions(),
                new NoSubtractMoveRestraintsConcrete(), new BasicMoveWorkerConcrete(), new BasicReturnBuildOptionsConcrete(),
                new BasicBuildBlockConcrete(), new BasicReturnBuildOptionsConcrete(), new BasicBuildBlockConcrete());
        myMatch.getGodList().add(apollo);

        assertEquals(apollo.getEffect(), effectApollo);

    }
}
