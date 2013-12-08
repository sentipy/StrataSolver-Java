package com.sentilabs.solvers.strata;

import java.util.Queue;

public class StrataGame implements IMovableCompletely {

    private int colours;

    private StrataBoard board;
    private StrataState state;

    /**
     *
     * @param size how many cells the board has on row (or column which is equal)
     * @param colours how many colours used
     */
    public StrataGame(int size, int colours){
        this.colours = colours;
        this.board = new StrataBoard(size);
        this.state = new StrataState(this.getSize());
    }

    public int getSize() {
        return this.board.getSize();
    }

    public int getColours() {
        return this.colours;
    }

    public IStrataBoard getBoard() {
        return this.board;
    }

    /**
     * sets the colour of a cell
     * @param pos position on the board (count from top left, from left to right, top down)
     * @param colour the number of colour (which is assigned by you) to which set the cell
     * @throws IllegalArgumentException
     */
    public void setPosColour(int pos, int colour) throws IllegalArgumentException{
        if (colour >= this.colours){
            throw new IllegalArgumentException("Colour is out of range!");
        }
        this.board.setPosColour(pos, colour);
    }

    /**
     * check whether current state can be a possible solution
     * @return whether current state can lead to solution
     */
    public boolean checkIsPossibleSolution(){
        int size = this.board.getSize();
        int totalSize = size * size;
        for (int i = 0; i < totalSize; ++i){
            int leftMove = i / size;
            int bottomMove = size + i % size;
            int posColour = this.board.getPosColour(i);
            if (posColour != -1 && this.state.isMoveMade(leftMove) && this.state.isMoveMade(bottomMove)
                    && posColour != this.state.getPosColour(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void makeMove(int move, int colour) throws IllegalArgumentException {
        this.state.makeMove(move, colour);
    }

    @Override
    public void undoLastMove() throws IllegalStateException {
        this.state.undoLastMove();
    }

    public boolean isMoveMade(int move) throws IllegalArgumentException{
        return this.state.isMoveMade(move);
    }

    public Queue<Move> getCurrentMoves(){
        return this.state.getCurrentMoves();
    }
}
