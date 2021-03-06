package com.sentilabs.solvers.strata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrataStateTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMakeMove() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeMoveWithIllegalMove() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.makeMove(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeMoveWithIllegalColour() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.makeMove(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeMoveDuplicate() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.makeMove(0, 0);
        strataState.makeMove(0, 0);
    }

    @Test(expected = IllegalStateException.class)
    public void testUndoLastMoveWithNoMoves() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.undoLastMove();
    }

    @Test
    public void testUndoLastMove() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.makeMove(0, 0);
        strataState.makeMove(2, 1);
        strataState.undoLastMove();
        assertEquals(strataState.getPosColour(0), 0);
        assertEquals(strataState.getPosColour(1), 0);
        strataState.undoLastMove();
        assertEquals(strataState.getPosColour(0), -1);
        assertEquals(strataState.getPosColour(1), -1);
    }

    @Test
    public void testGetPosColour() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.makeMove(0, 0);
        assertEquals(0, strataState.getPosColour(0));
        assertEquals(0, strataState.getPosColour(1));
        strataState.makeMove(2, 1);
        assertEquals(1, strataState.getPosColour(2));
        assertEquals(1, strataState.getPosColour(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalGetPosColour() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.getPosColour(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalGetPosColour2() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.getPosColour(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalIsMoveMade() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.isMoveMade(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalIsMoveMade2() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.isMoveMade(4);
    }

    @Test
    public void testIsMoveMade() throws Exception {
        StrataState strataState = new StrataState(2);
        strataState.makeMove(0, 0);
        assertEquals(true, strataState.isMoveMade(0));
        assertEquals(false, strataState.isMoveMade(1));
        strataState.makeMove(1, 0);
        assertEquals(true, strataState.isMoveMade(1));
    }
}
