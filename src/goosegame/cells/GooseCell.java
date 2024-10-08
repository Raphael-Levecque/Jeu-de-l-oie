package goosegame.cells;


public class GooseCell extends Cell {

    /**
     * Creates a new cell at a given position, initially there is no player
     * on this cell
     * @param position the position of this cell
     */
    public GooseCell(int position) {
        super(position);
    }

    /** 
     * 
     * @param diceThrow the 2d6 throw of a player
     * @return the rebounds caused by this cell
     */
    public int rebounds(int diceThrow) {
        return diceThrow;
    }

    public String toString() {
        return Integer.toString(this.position) + " (goose)";
    }


}
