package com.sentilabs.solvers.strata;

public class StrataBoardTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIllegalArgForContructor(){
        new StrataBoard(-1);
    }
}
