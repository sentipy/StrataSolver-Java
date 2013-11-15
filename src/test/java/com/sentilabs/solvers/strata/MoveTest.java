package com.sentilabs.solvers.strata;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoveTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetMove() throws Exception {
        this.testGetColour();
    }

    @Test
    public void testGetColour() throws Exception {
        Move move = new Move(1, 1);
        Assert.assertEquals(1, move.getColour());
        Assert.assertEquals(1, move.getMove());
        move = new Move(1, 2);
        Assert.assertEquals(2, move.getColour());
        Assert.assertEquals(1, move.getMove());
        move = new Move(2, 1);
        Assert.assertEquals(1, move.getColour());
        Assert.assertEquals(2, move.getMove());
    }

    @Test
    public void testToString() throws Exception {
        Move move = new Move(1, 1);
        Assert.assertEquals("(1, 1)", move.toString());
        move = new Move(1, 2);
        Assert.assertEquals("(1, 2)", move.toString());
        move = new Move(2, 1);
        Assert.assertEquals("(2, 1)", move.toString());
    }
}
