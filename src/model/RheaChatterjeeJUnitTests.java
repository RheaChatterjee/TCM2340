package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RheaChatterjee on 11/10/16.
 */
public class RheaChatterjeeJUnitTests {

    private InputChecker test;
    private boolean valid;

    @Before
    public void setUp() {
        test = new InputChecker();
        boolean valid = true;
    }

    @Test
    public void invalidLength0() {
        valid = test.checkEmail("");
        assertTrue(valid == false);
    }

    @Test
    public void invalidLength1() {
        valid = test.checkEmail("@");
        assertTrue(valid == false);
    }

    @Test
    public void invalidLength2() {
        valid = test.checkEmail("@.");
        assertTrue(valid == false);
    }

    @Test
    public void invalidSyntax0() {
        valid = test.checkEmail("test");
        assertTrue(valid == false);
    }

    @Test
    public void invalidSyntax1() {
        valid = test.checkEmail("test@");
        assertTrue(valid == false);
    }

    @Test
    public void valid() {
        valid = test.checkEmail("test@.");
        assertTrue(valid == true);
    }

}
