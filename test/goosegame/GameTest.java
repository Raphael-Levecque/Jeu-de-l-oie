package goosegame;

import org.junit.jupiter.api.*;

import goosegame.cells.*;


import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void addPlayerTest() {
        Board b = new ClassicalBoard();
        Player p = new Player("Duncan");
        Game g = new Game(b);
        assertFalse(g.getPlayers().contains(p));
        g.addPlayer(p);
        assertTrue(g.getPlayers().contains(p));
    }

    @Test
    public void isGameFinishedWhenNoPlayerAtLastCell() {
        Board b = new ClassicalBoard();
        Player p = new Player("Duncan");
        Cell c = new Cell(0);
        Game g = new Game(b);
        p.setCell(c);
        g.addPlayer(p);
        assertFalse(g.isGameFinished());
    }

    @Test 
    public void isGameFinishedWhenOnePlayerAtLastCell() {
        Board b = new ClassicalBoard();
        Player p = new Player("Gurney");
        Cell c = b.getCell(63);
        Game g = new Game(b);
        g.addPlayer(p);
        p.setCell(c);
        assertTrue(g.isGameFinished());
    }

    


}
