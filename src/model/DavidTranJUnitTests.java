package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DavidTranJUnitTests {
    private InputChecker test;
    private String errorMessage;
    private boolean valid;

    @Before
    public void setUp() {
        test = new InputChecker();
        errorMessage ="";
    }

    @Test
    public void invalidNegLongitude() {
        errorMessage = test.checkReportInput(-181, 0, "condition", "type");
        assertTrue(errorMessage.equals("Longitude field is invalid! Below -180 degrees.\n"));
    }

    @Test
    public void invalidPosLongitude() {
        errorMessage = test.checkReportInput(181, 0, "condition", "type");
        assertTrue(errorMessage.equals("Longitude field is invalid! Above 180 degrees.\n"));
    }

    @Test
    public void invalidNegLatitude() {
        errorMessage = test.checkReportInput(0, -91, "condition", "type");
        assertTrue(errorMessage.equals("Latitude field is invalid! Below -90 degrees.\n"));
    }

    @Test
    public void invalidPosLatitude() {
        errorMessage = test.checkReportInput(0, 91, "condition", "type");
        assertTrue(errorMessage.equals("Latitude field is invalid! Above 90 degrees.\n"));
    }

    @Test
    public void invalidNullCondition() {
        errorMessage = test.checkReportInput(0, 0, null, "type");
        assertTrue(errorMessage.equals("Condition cannot be null.\n"));
    }

    @Test
    public void invalidEmptyCondition() {
        errorMessage = test.checkReportInput(0, 0, "", "type");
        assertTrue(errorMessage.equals("Condition cannot have length 0.\n"));
    }

    @Test
    public void invalidNullType() {
        errorMessage = test.checkReportInput(0, 0, "condition", null);
        assertTrue(errorMessage.equals("Type cannot be null.\n"));
    }

    @Test
    public void invalidEmptyType() {
        errorMessage = test.checkReportInput(0, 0, "condition", "");
        assertTrue(errorMessage.equals("Type cannot have length 0.\n"));
    }

    @Test
    public void invalidConditionAndType() {
        errorMessage = test.checkReportInput(0, 0, null, null);
        assertTrue(errorMessage.equals("Type and condition cannot be null.\n"));
    }

    @Test
    public void validInput() {
        errorMessage = test.checkReportInput(0, 0, "condition", "type");
        assertTrue(valid == true);
    }
}
