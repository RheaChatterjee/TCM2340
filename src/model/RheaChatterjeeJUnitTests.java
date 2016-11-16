package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RheaChatterjee on 11/10/16.
 * 
 * JUnit test for checkEmail method in InputChecker
 */
public class RheaChatterjeeJUnitTests {

    private InputChecker test;
    private boolean valid;

    @Before
    public void setUp() {
        test = new InputChecker();
    }

    @Test
    public void invalidLength0() {
        valid = test.checkEmail("");
        assertTrue(!valid);
    }

    @Test
    public void invalidLength1() {
        valid = test.checkEmail("@");
        assertTrue(!valid);
    }

    @Test
    public void invalidLength2() {
        valid = test.checkEmail("@.");
        assertTrue(!valid);
    }

    @Test
    public void invalidSyntax0() {
        valid = test.checkEmail("test");
        assertTrue(!valid);
    }

    @Test
    public void invalidSyntax1() {
        valid = test.checkEmail("test@");
        assertTrue(!valid);
    }

    @Test
    public void valid() {
        valid = test.checkEmail("test@.");
        assertTrue(!valid);
    }

}
