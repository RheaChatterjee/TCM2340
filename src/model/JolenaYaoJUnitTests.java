package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JolenaYaoJUnitTests {
    private InputChecker test;
    private String errorMessage;

    @Before
    public void setUp() {
        test = new InputChecker();
        errorMessage = "";
    }

    @Test
    public void tooNegLong() {
        errorMessage = test.checkQualReportInput(-190, 0, "test", "test", "test");
        assertTrue(errorMessage.equals("Longitude field is invalid!\n"));
    }

    @Test
    public void tooPosLong() {
        errorMessage = test.checkQualReportInput(190, 0, "test", "test", "test");
        assertTrue(errorMessage.equals("Longitude field is invalid!\n"));
    }

    @Test
    public void tooNegLat() {
        errorMessage = test.checkQualReportInput(0, -190, "test", "test", "test");
        assertTrue(errorMessage.equals("Latitude field is invalid!\n"));
    }

    @Test
    public void tooPosLat() {
        errorMessage = test.checkQualReportInput(0, 100, "test", "test", "test");
        assertTrue(errorMessage.equals("Latitude field is invalid!\n"));
    }

    @Test
    public void nullCondition() {
        errorMessage = test.checkQualReportInput(0, 0, null, "test", "test");
        assertTrue(errorMessage.equals("No valid water condition entered!\n"));
    }

    @Test
    public void emptyCondition() {
        errorMessage = test.checkQualReportInput(0, 0, "", "test", "test");
        assertTrue(errorMessage.equals("No valid water condition entered!\n"));
    }

    @Test
    public void nullVirusPPM() {
        errorMessage = test.checkQualReportInput(0, 0, "test", null, "test");
        assertTrue(errorMessage.equals("No valid virusPPM entered!\n"));
    }

    @Test
    public void emptyVirusPPM() {
        errorMessage = test.checkQualReportInput(0, 0, "test", "", "test");
        assertTrue(errorMessage.equals("No valid virusPPM entered!\n"));
    }

    @Test
    public void nullContamPPM() {
        errorMessage = test.checkQualReportInput(0, 0, "test", "test", null);
        assertTrue(errorMessage.equals("No valid contamPPM entered!\n"));
    }

    @Test
    public void emptyContamPPM() {
        errorMessage = test.checkQualReportInput(0, 0, "test", "test", "");
        assertTrue(errorMessage.equals("No valid contamPPM entered!\n"));
    }

    @Test
    public void invalid() {
        errorMessage = test.checkQualReportInput(-190, 100, null, null, null);
        String mes = "";
        mes += "Longitude field is invalid!\n";
        mes += "Latitude field is invalid!\n";
        mes += "No valid water condition entered!\n";
        mes += "No valid virusPPM entered!\n";
        mes += "No valid contamPPM entered!\n";
        System.out.println(errorMessage);
        assertTrue(errorMessage.equals(mes));
    }

    @Test
    public void valid() {
        errorMessage = test.checkQualReportInput(0, 0, "test", "test", "test");
        assertTrue(errorMessage.equals(""));
    }
}
