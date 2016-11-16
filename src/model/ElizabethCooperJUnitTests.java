package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElizabethCooperJUnitTests {
    private InputChecker test;
    private String errorMessage;
    @Before
    public void setUp() {
        test = new InputChecker();
        errorMessage ="";
    }

    @Test
    public void nullName() {
        errorMessage = test.checkRegistrationInput(null, "test", "test@", "test", "test", "test");
        assertTrue(errorMessage.equals("Not a valid username!\n"));
    }

    @Test
    public void nullPassword() {
        errorMessage = test.checkRegistrationInput("test", null, "test@", "test", "test", "test");
        assertTrue(errorMessage.equals("No valid password entered! Please make password longer than four characters! \n"));
    }

    @Test
    public void nullEmail() {
        errorMessage = test.checkRegistrationInput("test", "test", null, "test", "test", "test");
        assertTrue(errorMessage.equals("No valid email entered!\n"));
    }

    @Test
    public void nullType() {
        errorMessage = test.checkRegistrationInput("test", "test", "test@", null, "test", "test");
        assertTrue(errorMessage.equals("No valid account type selected\n"));
    }

    @Test
    public void nullAddress() {
        errorMessage = test.checkRegistrationInput("test", "test", "test@", "test", null, "test");
        assertTrue(errorMessage.equals("No valid address entered!\n"));
    }

    @Test
    public void nullTitle() {
        errorMessage = test.checkRegistrationInput("test", "test", "test@", "test", "test", null);
        assertTrue(errorMessage.equals("No valid title entered!\n"));
    }

    @Test
    public void emptyName() {
        errorMessage = test.checkRegistrationInput("", "test", "test@", "test", "test", "test");
        assertTrue(errorMessage.equals("Not a valid username!\n"));
    }

    @Test
    public void shortPassword() {
        errorMessage = test.checkRegistrationInput("test", "pas", "test@", "test", "test", "test");
        assertTrue(errorMessage.equals("No valid password entered! Please make password longer than four characters! \n"));
    }

    @Test
    public void emptyEmail() {
        errorMessage = test.checkRegistrationInput("test", "test", "", "test", "test", "test");
        assertTrue(errorMessage.equals("No valid email entered!\n"));
    }

    @Test
    public void emptyAddress() {
        errorMessage = test.checkRegistrationInput("test", "test", "test@", "test", "", "test");
        assertTrue(errorMessage.equals("No valid address entered!\n"));
    }

    @Test
    public void emptyTitle() {
        errorMessage = test.checkRegistrationInput("test", "test", "test@", "test", "test", "");
        assertTrue(errorMessage.equals("No valid title entered!\n"));
    }

    @Test
    public void invalidEmail() {
        errorMessage = test.checkRegistrationInput("test", "test", "test", "test", "test", "test");
        assertTrue(errorMessage.equals("No valid email entered!\n"));
    }

    @Test
    public void invalidEverything() {
        errorMessage = test.checkRegistrationInput(null, null, null, null, null, null);
        String message = "";
        message += "Not a valid username!\n";
        message += "No valid password entered! Please make password longer than four characters! \n";
        message += "No valid email entered!\n";
        message += "No valid account type selected\n";
        message += "No valid address entered!\n";
        message += "No valid title entered!\n";
        assertTrue(errorMessage.equals(message));
    }

    @Test
    public void validEverything() {
        errorMessage = test.checkRegistrationInput("test", "test", "test@", "test", "test", "test");
        assertTrue(errorMessage.equals(""));
    }
}