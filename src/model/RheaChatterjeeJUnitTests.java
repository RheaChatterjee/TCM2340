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
    public void invalidLength() {
        valid = test.checkEmail("");
        assertTrue(valid == false);
    }

    @Test
    public void invalidSyntax() {
        valid = test.checkEmail("e");
        assertTrue(valid == false);
    }

    @Test
    public void validLength() {
        valid = test.checkEmail("email");
        assertTrue(valid == false);
    }

    @Test
    public void validSyntax() {
        valid = test.checkEmail("@");
        assertTrue(valid == true);
    }

    @Test
    public void validBoth() {
        valid = test.checkEmail("email@");
        assertTrue(valid == true);
    }

}
