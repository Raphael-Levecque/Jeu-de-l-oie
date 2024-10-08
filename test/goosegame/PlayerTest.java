package goosegame;

import goosegame.cells.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void setCellAndGetCellTest() {
        Cell c = new Cell(0);
        Player p = new Player("Vladimir");
        assertEquals(null,p.getCell());
        p.setCell(c);
        assertEquals(c,p.getCell());
    }

    @Test 
    public void constructorTest() {
        Player p = new Player("Jessica");
        assertEquals("Jessica",p.getName());
        assertEquals(null,p.getCell());
    }



}
