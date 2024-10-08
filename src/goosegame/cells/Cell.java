package goosegame.cells;

import goosegame.Player;

public class Cell {
    //Attributes

    /*The player on this cell */
    protected Player player;
    /*The position on the board of this cell */
    protected int position;


    //Constructor

    /**
     * Creates a new cell at a given position, initially there is no player
     * on this cell
     * @param position the position of this cell
     */
    public Cell(int position) {
        this.position = position;
        this.player = null;
    }

    /** 
     * 
     * @param diceThrow the 2d6 throw of a player
     * @return the rebounds caused by this cell
     */
    public int rebounds(int diceThrow) {
        return 0;
    }

    /**
     * @return the position of this cell
     */
    public int getPosition() {
        return this.position; 
    }

    /** Adds a player to this cell
     * 
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the player of this cell
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Removes the player of this cell
     */
    public void removePlayer() {
        this.player = null;
    }

    /**
     * @return true iff there is a player on this cell
     */
    public boolean isOccupied() {
        return this.player != null;
    }

    /**
     * @return true iff this cell allows the player to play
     */
    public boolean canPlay() {
        return true;
    }

    public String toString() {
        return Integer.toString(this.position);
    }

}
