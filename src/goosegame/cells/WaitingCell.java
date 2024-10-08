package goosegame.cells;

import goosegame.Player;

public class WaitingCell extends Cell {

    /*The number of laps to wait for the player on this cell before being able to play */
    protected int nbOfLapsToWait;
    /*The current number of laps to wait for the player on this cell before being able to play */
    protected int currentNbOfLapsToWait;
    
    /**
     * Creates a new cell at a given position, initially there is no player on this cell
     * @param position the position of this cell
     * @param nbOfLapsToWait the number of laps to wait for the player on this cell before being able to play
     */
    public WaitingCell(int position, int nbOfLapsToWait){
        super(position);
        this.nbOfLapsToWait = nbOfLapsToWait;
    }

    /** Adds a player to this cell
     * 
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        super.addPlayer(player);
        this.reinitNbOfLapsToWait();
    }

    /**
     * Reinitializes the number of laps to wait for the player on this cell before being able to play
     */
    protected void reinitNbOfLapsToWait() {
        this.currentNbOfLapsToWait = this.nbOfLapsToWait;
    }

    /**
     * @return true iff this cell allows the player to play
     */
    public boolean canPlay() {
        if (this.currentNbOfLapsToWait > 0) {
            this.currentNbOfLapsToWait--;
            return false;
        }
        else {
            return true;
        }
    }

    public String toString() {
        return Integer.toString(this.position) + " (waiting for "+this.nbOfLapsToWait+" turns)";
    }
}
