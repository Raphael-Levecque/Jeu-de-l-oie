package goosegame.cells;

public class TrapCell extends Cell {

    /**
     * Creates a new cell at a given position, initially there is no player
     * on this cell
     * @param position the position of this cell
     */
    public TrapCell(int position) {
        super(position);
    }

    /**
     * @return true iff this cell allows the player to play
     */
    public boolean canPlay() {
        return false;
    }

    public String toString() {
        return Integer.toString(this.position) + " (trap)";
    }
}
