package goosegame.cells;

public class TeleportationCell extends Cell {

    protected final int destinationPosition;

    /**
     * Creates a new cell at a given position, initially there is no player on this cell
     * @param position the position of this cell
     * @param destinationPosition the position after being teleported by this cell
     */
    public TeleportationCell(int position, int destinationPosition) {
        super(position);
        this.destinationPosition = destinationPosition;
    }

    /** 
     * 
     * @param diceThrow the 2d6 throw of a player
     * @return the rebounds caused by this cell
     */
    public int rebounds(int diceThrow) {
        return this.destinationPosition - this.position;
    }

    public String toString() {
        return Integer.toString(this.position) + " (teleport to "+this.destinationPosition+")";
    }

}
