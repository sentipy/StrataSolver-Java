package com.sentilabs.solvers.strata;

import java.util.*;

public class StrataSolver {

    private static boolean solveAll(StrataGame game, int currentMoveNumber, List<Queue<Move>> solutions) throws IllegalStateException{
        int size = game.getSize();
        int moves = 2 * size;
        if (currentMoveNumber == moves){
            if (solutions != null)
                solutions.add(game.getCurrentMoves());
        }
        for (int i = 0; i < moves; ++i){
            if (!game.isMoveMade(i)){
                int colours = game.getColours();
                for (int j = 0; j < colours; ++j){
                    game.makeMove(i, j);
                    if (game.checkIsPossibleSolution()){
                        solveAll(game, currentMoveNumber + 1, solutions);
                    }
                    game.undoLastMove();
                }
            }
        }
        return false;
    }

    private static boolean solveFirst(StrataGame game, int currentMoveNumber) throws IllegalStateException{
        int size = game.getSize();
        int moves = 2 * size;
        if (currentMoveNumber == moves){
            return true;
        }
        for (int i = 0; i < moves; ++i){
            if (!game.isMoveMade(i)){
                int colours = game.getColours();
                for (int j = 0; j < colours; ++j){
                    game.makeMove(i, j);
                    if (game.checkIsPossibleSolution()){
                        if (solveFirst(game, currentMoveNumber + 1)){
                            return true;
                        }
                    }
                    game.undoLastMove();
                }
            }
        }
        return false;
    }

    public static Queue<Move> solve(StrataGame game) throws IllegalStateException{
        solveFirst(game, 0);
        return game.getCurrentMoves();
    }

    public static List<Queue<Move>> solveAll(StrataGame game) throws IllegalStateException{
        List<Queue<Move>> sols = new ArrayList<Queue<Move>>();
        solveAll(game, 0, sols);
        return sols;
    }

}
