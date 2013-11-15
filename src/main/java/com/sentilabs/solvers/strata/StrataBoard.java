package com.sentilabs.solvers.strata;

public class StrataBoard implements IStrataBoard {

    private int size;
    private int lastPos;
    private int[] posColours;

    public StrataBoard(int size){
        if (size < 1){
            throw new IllegalArgumentException("sideSize must be positive!");
        }
        this.size = size;
        this.lastPos = this.size * this.size - 1;
        this.posColours = new int[this.lastPos + 1];
        int max = this.posColours.length;
        for (int i = 0; i < max; ++i){
            this.posColours[i] = -1;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getPosColour(int pos) throws IllegalArgumentException{
        if (pos < 0 || pos > this.lastPos){
            throw new IllegalArgumentException();
        }
        return this.posColours[pos];
    }

    public void setPosColour(int pos, int colour){
        if (pos < 0 || pos > this.lastPos){
            throw new IllegalArgumentException("Position is out of range!");
        }
        if (colour < 0){
            throw new IllegalArgumentException("Colour must be nonnegative!");
        }
        this.posColours[pos] = colour;
    }

}
