package goosegame;

import java.util.*;
import goosegame.cells.*;

/*A class representing the goose game */
public class Game {
    //Attributes 

    protected Iterator<Player> it;
    /*The players of this game */
    protected List<Player> thePlayers;
    /*The board of this game */
    protected Board board;

    //Constructor
    /**
     * Initialize the board, initially there is no player
     * @param board the board for this game
     */
    public Game(Board board) {
        this.thePlayers = new ArrayList<>();
        this.board = board;
    }

    //Methods
    /**
     * Adds a player to this game
     * @param p the player to add
     */
    public void addPlayer(Player p) {
        p.setCell(new Cell(0));
        this.thePlayers.add(p);
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return this.thePlayers;
    }

    /**
     * Plays a goose game 
     */
    public void play() {
        this.initPlayersIterator();
        while(!this.isGameFinished()) {
            Player player = nextPlayer();
            if (player.canPlay()) {
                this.playerPlay(player);
            }
            else {
                System.out.println(player+" can not play :-(");
            }
        }
    }

    protected void initPlayersIterator() {
        this.it = this.thePlayers.iterator();
    }

    /**
     * Check if the game is finished 
     * @return true iff the game is finished (one player reach last cell)
     */
    protected boolean isGameFinished() {
        boolean finished = false;
        for(Player player: this.thePlayers) {
            if (player.getCell().getPosition() == this.board.getNbOfCells()) {
                finished = true;
                System.out.println(player+" has won !");
            }
        }
        return finished;
    }

    /**
     * 
     * @return the next player to play
     */
    public Player nextPlayer() {
        Player player;
        if (this.it.hasNext()) {
            player = it.next();
            return player;
        }
        else {
            this.it = this.thePlayers.iterator();
            player = it.next();
            return player;
        }
    }

    /** A player plays a round
     * 
     * @param player the player who is playing
     */
    protected void playerPlay(Player player) {
        int currentPosition = player.getCell().getPosition();
        int diceThrow = player.twoDiceThrow();
        int destinationPosition = currentPosition + diceThrow;
        Cell destinationCell = this.calculateNewCell(currentPosition, destinationPosition);
        int rebouncePosition = destinationCell.rebounds(diceThrow);
        Cell finalCell = this.calculateNewCell(destinationCell.getPosition(),destinationCell.getPosition() + rebouncePosition);
        if (finalCell.isOccupied()) {
            this.swapPlayers(currentPosition, finalCell);
        }
        player.setCell(finalCell);
        if (rebouncePosition != 0) {
            System.out.println(player+" is in cell "+currentPosition+", "+player+" throws "+diceThrow+" and reaches cell "+destinationCell+" and jumps to cell "+finalCell);
        }
        else {
            System.out.println(player+" is in cell "+currentPosition+", "+player+" throws "+diceThrow+" and reaches cell "+destinationCell);
        }

    }

    /** Calculate the new position of a player 
     * 
     * @param currentPosition the current position of the player
     * @param destinationPosition the position determined by the 2d6 throw
     * @return the new position
     */
    protected Cell calculateNewCell(int currentPosition, int destinationPosition) {
        if (destinationPosition > board.getNbOfCells()) {
            int stepBack = destinationPosition - board.getNbOfCells();
            int newCell = board.getNbOfCells() - stepBack;
            return this.board.getCell(newCell);
        }
        else {
            return this.board.getCell(destinationPosition);
        }
    }

    /** Swap players if one arrives at an occupied cell
     * 
     * @param currentPosition the current position of a player
     * @param finalCell the destination of this player
     */
    protected void swapPlayers(int currentPosition, Cell finalCell) {
        Player player2 = finalCell.getPlayer();
        if (currentPosition == 0) {
            Cell cell = new Cell(0);
            player2.setCell(cell);
        }
        else {
            Cell cell = board.getCell(currentPosition);
            player2.setCell(cell);
        }
    }

    
}