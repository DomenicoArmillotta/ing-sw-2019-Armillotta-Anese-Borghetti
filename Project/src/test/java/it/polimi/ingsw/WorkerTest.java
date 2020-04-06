package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class WorkerTest {
    @Test
    public void CostructorTest(){
        Player n1 = new Player("Marco");
        Cell cell1=new Cell();
        Worker worker1=new Worker(n1,cell1,Level.GROUND);
        assertEquals(worker1.getOwner(),n1);
        assertEquals(worker1.getCurrentPosition(),cell1);
        assertEquals(worker1.getPreviousPosition(),cell1);
        assertEquals(worker1.getPreviousLevel(),Level.GROUND);
    }

}