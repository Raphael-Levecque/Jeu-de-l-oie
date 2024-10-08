package goosegame;

import goosegame.cells.*;

/*A class representing a goose game board */
public class ClassicalBoard extends Board {
    //Attributes

    /*The number of cell of this board*/
    public static final int NB_OF_CELLS = 63;

    //Constructor

    /**
     * Initialize the board
     */
    public ClassicalBoard() {
        super(ClassicalBoard.NB_OF_CELLS);
    }

    /**
     * Initialize a classical goose game board
     */
    protected void initBoard() {
        for(int i = 1 ; i <= ClassicalBoard.NB_OF_CELLS ; i++) {
            if (i == 9 || i == 18 || i == 27 || i == 36 || i == 45 || i == 54) {
                this.theCells[i] = new GooseCell(i);
            }
            else if (i == 31 || i == 52) {
                this.theCells[i] = new TrapCell(i);
            }
            else if (i == 19) {
                this.theCells[i] = new WaitingCell(i, 2);
            }
            else if (i == 6) {
                this.theCells[i] = new TeleportationCell(i, 12);
            }
            else if (i == 42) {
                this.theCells[i] = new TeleportationCell(i, 30);
            }
            else if (i == 58) {
                this.theCells[i] = new TeleportationCell(i, 1);
            }
            else {
                this.theCells[i] = new Cell(i);
            }
        }
    }
}
