package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GodCardTest  {
    @Test
        public void CostructorTest(){
            String nome=new String("Apollo");
            String descrizione=new String("bla");
            GodCard godCard=new GodCard(nome,descrizione);
            assertEquals(godCard.getGodName(),nome);
            assertEquals(godCard.getDescription(),descrizione);
        }
    @Test
        public void EffectTest(){

            Effect effectApollo = new Effect();
            effectApollo.setEffectStrategies(new BasicSelectOptionsConcrete(), new BasicMoveOptionsConcrete(), new MoveSwitchingWorkersConcrete(), new BasicWinCheckConcrete(), new NoSecondMoveConcrete(), new BasicBuildConcrete());
            GodCard apollo = new GodCard("Apollo","bla bla");
            apollo.setEffect(effectApollo);
            assertEquals(apollo.getEffect(),effectApollo);
        }

}