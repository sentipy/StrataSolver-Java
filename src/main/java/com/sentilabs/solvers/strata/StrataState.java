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

    @Override
    public int getPosColour(int pos) throws IllegalArgumentException {
        if (pos < 0 || pos >= this.states.size()){
            throw new IllegalArgumentException("Position is out of range!");
        }
        return this.states.get(pos).peek();
    }

    public boolean isMoveMade(int move) throws IllegalArgumentException{
        if (move < 0 || move >= this.movesStates.length){
            throw new IllegalArgumentException("Move is out of range!");
        }
        return this.movesStates[move];
    }

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
