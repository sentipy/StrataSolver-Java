package com.sentilabs.solvers.strata;

import junit.framework.Assert;

public class StrataGameTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetSize() throws Exception {
        StrataGame strataGame = new StrataGame(3, 3);
        Assert.assertEquals(3, strataGame.getSize());
        strataGame = new StrataGame(4, 2);
        Assert.assertEquals(4, strataGame.getSize());
        strataGame = new StrataGame(2, 4);
        Assert.assertEquals(2, strataGame.getSize());
    }

    @org.junit.Test
    public void testGetColours() throws Exception {
        StrataGame strataGame = new StrataGame(3, 3);
        Assert.assertEquals(3, strataGame.getColours());
        strataGame = new StrataGame(4, 2);
        Assert.assertEquals(2, strataGame.getColours());
        strataGame = new StrataGame(2, 4);
        Assert.assertEquals(4, strataGame.getColours());
    }

    @org.junit.Test
    public void testGetPosColour() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.setPosColour(0, 0);
        strataGame.setPosColour(1, 1);
        strataGame.setPosColour(2, 1);
        strataGame.setPosColour(3, 0);
        Assert.assertEquals(0, strataGame.getBoard().getPosColour(0));
        Assert.assertEquals(1, strataGame.getBoard().getPosColour(1));
        Assert.assertEquals(1, strataGame.getBoard().getPosColour(2));
        Assert.assertEquals(0, strataGame.getBoard().getPosColour(3));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIllegalGetPosColour() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.getBoard().getPosColour(-1);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIllegalGetPosColour2() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.getBoard().getPosColour(4);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testExceptionSetIllegalColour() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.setPosColour(0, 2);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testExceptionSetIllegalColour2() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.setPosColour(0, -1);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testExceptionSetColourInIllegalPos() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.setPosColour(-1, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testExceptionSetColourInIllegalPos2() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.setPosColour(-1, 4);
    }

    @org.junit.Test
    public void testCheckIsPossibleSolution() throws Exception {
        StrataGame strataGame = new StrataGame(2, 2);
        strataGame.setPosColour(0, 0);
        strataGame.setPosColour(1, 1);
        strataGame.makeMove(0, 0);
        Assert.assertEquals(true, strataGame.checkIsPossibleSolution());
        strataGame.makeMove(2, 1);
        Assert.assertEquals(false, strataGame.checkIsPossibleSolution());
        strataGame.undoLastMove();
        strataGame.makeMove(2, 0);
        Assert.assertEquals(true, strataGame.checkIsPossibleSolution());
    }
}
