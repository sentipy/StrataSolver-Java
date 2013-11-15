package com.sentilabs.solvers.strata;

public class Move {

    private int move;
    private int colour;

    public Move(int move, int colour){
        this.move = move;
        this.colour = colour;
    }

    public int getMove() {
        return move;
    }

    public int getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "(" + this.move + ", " + this.colour + ")";
    }
}
