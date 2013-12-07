package com.sentilabs.solvers.strata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class StrataSolverTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testEmptyConstructor() throws Exception {
        new StrataSolver();
    }

    @Test
    public void testSolve() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.setPosColour(0, 0);
        strataGame.setPosColour(1, 1);
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve2x2() throws Exception {
        StrataGame strataGame = new StrataGame(2, 3);
        int[] colours = {2, 1
                , -1, 0};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve2x2_2() throws Exception {
        StrataGame strataGame = new StrataGame(2, 3);
        int[] colours = {-1, 0
                , 2, 1};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve2x2_3() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        int[] colours = {0, 1
                , 1, 0};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        List<Queue<Move>> sols = StrataSolver.solveAll(strataGame);
        assertEquals(0, sols.size());
    }

    @Test
    public void testSolve2x2_4() throws Exception {
        StrataGame strataGame = new StrataGame(2, 1);
        int[] colours = {0, 0
                , 0, 0};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        List<Queue<Move>> sols = StrataSolver.solveAll(strataGame);
        assertEquals(24, sols.size());
    }

    @Test
    public void testSolve3x3() throws Exception {
        StrataGame strataGame = new StrataGame(3, 2);
        int[] colours = {1, 1, -1
                , -1, -1, 0
                , 1, -1, 1};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve3x3_2() throws Exception {
        StrataGame strataGame = new StrataGame(3, 2);
        int[] colours = {1, 0, 1
                , 0, -1, 0
                , 1, 1, 1};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve3x3_3() throws Exception {
        StrataGame strataGame = new StrataGame(3, 3);
        int[] colours = {-1, 1, 1
                , 1, 2, -1
                , 1, -1, 0};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve3x3_4() throws Exception {
        StrataGame strataGame = new StrataGame(3, 3);
        int[] colours = {1, 0, 0
                , 1, 2, 0
                , 2, -1, 2};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve4x4() throws Exception {
        StrataGame strataGame = new StrataGame(4, 4);
        int[] colours = {2, 1, 0, 1
            , 0, 0, -1, 0
            , 1, -1, 1, 1
            , 3, 1, 0, 1};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve4x4_2() throws Exception {
        StrataGame strataGame = new StrataGame(4, 4);
        int[] colours = {0, 0, -1, 0
                , 2, -1, 2, 3
                , 1, 3, 1, 1
                , 2, 3, 2, 1};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        Queue<Move> moves = StrataSolver.solve(strataGame);
        assertEquals(true, moves.size() > 0);
    }

    @Test
    public void testSolve4x4_3() throws Exception {
        StrataGame strataGame = new StrataGame(4, 4);
        int[] colours = {0, 0, -1, 0
                , 2, -1, 2, 3
                , 1, 3, 1, 1
                , 2, 3, 2, 1};
        for (int i = 0; i < colours.length; ++i){
            if (colours[i] == -1)
                continue;
            strataGame.setPosColour(i, colours[i]);
        }
        List<Queue<Move>> sols = StrataSolver.solveAll(strataGame);
        assertEquals(true, sols.size() > 0);
    }
}
