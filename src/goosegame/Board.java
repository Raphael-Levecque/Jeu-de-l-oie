package goosegame;

import goosegame.cells.*;

public abstract class Board {
    //Attributes

    /*Number of cell of a board */
    protected final int nbOfCells;

    /*Cells of a board */
    protected Cell[] theCells;

    //Constructor

    /**
     * Initialize a board
     * @param nbOfCells the number of cell of the board
     */
    public Board(int nbOfCells) {
        this.nbOfCells = nbOfCells;
        this.theCells = new Cell[nbOfCells+1];
        this.initBoard();
    }

    //Methods
    /**
     * Initialize the cells of the board
     */
    protected abstract void initBoard(); 

    /**
     * @param index a position of on the board
     * @return the cell of the board at the index position
     */
    public Cell getCell(int index) {
        return this.theCells[index];
    }

    /**
     * 
     * @return the number of cell of the board
     */
    public int getNbOfCells() {
        return this.theCells.length-1;
    }

}
