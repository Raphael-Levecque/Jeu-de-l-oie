package goosegame;

import java.util.Random;
import goosegame.cells.*;

/**A player in the goosegame */
public class Player {
    private static Random random = new Random();

    /** current cell of the player */
    protected Cell cell;

    /** name of the player */
    protected String name;

    //Constructor

    /**
     * @param name the name of this player
     */
    public Player (String name) {
        this.name = name;
        this.cell = null;
    }

    //Methods

    /** @see Object#toString() */
    public String toString() {
        return this.name;
    }

    /**
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /** @return the current cell of the player */
    public Cell getCell() {
        return this.cell;
    }

    /** changes the cell of the player
     * @param newCell the new cell
     */
    public void setCell(Cell newCell) {
        this.removePlayerFromCurrentCell();
        this.cell = newCell;
        this.cell.addPlayer(this);
    }

    private void removePlayerFromCurrentCell() {
        if (this.cell != null) {
            this.cell.removePlayer();
        }
    } 

    /** @return random result of a 1d6 throw*/
    private int oneDiceThrow() {
        return Player.random.nextInt(6)+1;
    }

    /** @return random result of 2d6 throw*/
    public int twoDiceThrow() {
        int result = oneDiceThrow() + oneDiceThrow();
        return result;
    }

    public boolean canPlay() {
        return this.cell.canPlay();
    }
}
