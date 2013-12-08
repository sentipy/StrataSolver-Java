package com.sentilabs.solvers.strata;

import java.util.*;

public class StrataState implements IPosColourProvider, IMovableCompletely {

    private int size;
    private ArrayList<Stack<Integer>> states;
    private boolean[] movesStates;
    private Stack<Integer> moves;
    private Stack<Integer> movesColours;

    public StrataState(int size){
        this.size = size;
        int totalSize = size * size;
        this.states = new ArrayList<Stack<Integer>>(totalSize);
        for (int i = 0; i < totalSize; ++i){
            Stack<Integer> st = new Stack<Integer>();
            st.push(-1);
            this.states.add(st);
        }
        this.movesStates = new boolean[size * 2];
        this.moves = new Stack<Integer>();
        this.movesColours = new Stack<Integer>();
    }

    /**
     * make move using specified move and colour
     * @param move - number of the move to make
     * @param colour - number of the colour (colour of the stripe) to use in this move
     * @throws IllegalArgumentException
     */
    @Override
    public void makeMove(int move, int colour) throws IllegalArgumentException{
        if (move < 0 || move >= this.movesStates.length){
            throw new IllegalArgumentException("Move is out of range!");
        }
        if (colour < 0){
            throw new IllegalArgumentException("Colour must be nonnegative!");
        }
        if (this.movesStates[move]){
            throw new IllegalArgumentException("This move has already been made!");
        }
        int inc;
        int first;
        if (move < this.size){
            first = this.size * move;
            inc = 1;
        }
        else{
            first = move - this.size;
            inc = this.size;
        }
        int curPos = first;
        for (int i = 0; i < this.size; ++i){
            this.states.get(curPos).push(colour);
            curPos += inc;
        }
        this.movesStates[move] = true;
        this.moves.push(move);
        this.movesColours.push(colour);
    }

    /**
     * undo the last made move thus reverting to state which precedes current one
     * @throws IllegalStateException
     */
    @Override
    public void undoLastMove() throws IllegalStateException {
        if (this.moves.size() == 0){
            throw new IllegalStateException();
        }
        int move = this.moves.pop();
        this.movesColours.pop();
        int inc;
        int first;
        if (move < this.size){
            first = this.size * move;
            inc = 1;
        }
        else{
            first = move - this.size;
            inc = this.size;
        }
        int curPos = first;
        for (int i = 0; i < this.size; ++i){
            this.states.get(curPos).pop();
            curPos += inc;
        }
        this.movesStates[move] = false;
    }

    /**
     * get the number of colour which the cell identified by pos currently has
     * @param pos - position on the board
     * @return the number of colour which the cell identified by pos currently has
     * N.B. it is not a colour of the board cell
     * it is a colour which board has after making moves (colour of the stripe which was last to cross specified cell)
     * @throws IllegalArgumentException
     */
    @Override
    public int getPosColour(int pos) throws IllegalArgumentException {
        if (pos < 0 || pos >= this.states.size()){
            throw new IllegalArgumentException("Position is out of range!");
        }
        return this.states.get(pos).peek();
    }

    /**
     *
     * @param move - number of the move. Refer to documentation to understand how the moves are numbered
     * @return true if specified move has been already made
     * @throws IllegalArgumentException
     */
    public boolean isMoveMade(int move) throws IllegalArgumentException{
        if (move < 0 || move >= this.movesStates.length){
            throw new IllegalArgumentException("Move is out of range!");
        }
        return this.movesStates[move];
    }

    /**
     * get currently made moves
     * @return queue of the made moves
     */
    public Queue<Move> getCurrentMoves(){
        LinkedList<Move> curMoves = new LinkedList<Move>();
        Iterator<Integer> itMoves = this.moves.iterator();
        Iterator<Integer> itColours = this.movesColours.iterator();
        while (itMoves.hasNext()){
            curMoves.add(new Move(itMoves.next(), itColours.next()));
        }
        return curMoves;
    }
}
