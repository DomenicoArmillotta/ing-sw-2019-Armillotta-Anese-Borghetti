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
        effectApollo.setEffectStrategies(new BasicReturnSelectOptionsConcrete(), new BasicSelectWorkerConcrete(),
                new BasicReturnBuildOptionsConcrete(), new BasicBuildBlockConcrete(), new BasicReturnMoveOptions(),
                new SubtractRestraintsDontMoveUpConcrete(), new BasicMoveWorkerConcrete(), new BasicReturnMoveOptions(),
                new SubtractRestraintsDontMoveUpConcrete(), new BasicMoveWorkerConcrete(), new BasicReturnBuildOptionsConcrete(),
                new BasicBuildBlockConcrete(), new BasicReturnBuildOptionsConcrete(), new BasicBuildBlockConcrete());
        GodCard apollo = new GodCard("Apollo", "bla bla");
        apollo.setEffect(effectApollo);
        assertEquals(apollo.getEffect(), effectApollo);
    }
    @Test
    public void OwnerTest(){
        Player n1 = new Player("Marco");
        GodCard apollo = new GodCard("Apollo","bla bla");
        apollo.setOwner(n1);
        assertEquals(apollo.getOwner(),n1);

    }



}