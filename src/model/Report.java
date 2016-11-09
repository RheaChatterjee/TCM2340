package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Report implements Serializable {

    private String dateTime = "";
    private String reportNumber = "";
    private String reporterName = "";
    private Location location = new Location();
    private String waterType = "";
    private String waterCondition = "";

    private static final long serialVersionUID = 1L;


    public Report() {
        DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy h:mm a");
        Date date = new Date();
        setDateTime(date.toString());
    }

    public Report(String reporterName, Location location, String waterType, String waterCondition) {
        SubmittedReports submittedReports = new SubmittedReports();
        setReportNumber(String.format("%05d", submittedReports.getArraySize() + 1));
        setReporterName(reporterName);
        setLocation(location);
        setWaterType(waterType);
        setWaterCondition(waterCondition);
        DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy h:mm a");
        String date = dateFormat.format(new Date());
        setDateTime(date);
    }

    /**
     * gets the year of the report
     * @return String of the year
     */
    public String getYear() {
        String year = getDateTime().substring(7, 11);
        return year;
    }

    private String getDateTime() {
        return dateTime;
    }

    public String dateTimeProperty() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    private String getReportNumber() {
        return reportNumber;
    }

    public String reportNumberProperty() {
        return reportNumber;
    }

    private void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    private String getReporterName() {
        return reporterName;
    }

    public String reporterNameProperty() {
        return reporterName;
    }

    private void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public Location getLocation() {
        return location;
    }

    private void setLocation(Location location) {
        this.location = location;
    }

    private String getWaterType() {
        return waterType;
    }

    public String waterTypeProperty() {
        return waterType;
    }

    private void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    private String getWaterCondition() {
        return waterCondition;
    }

    public String waterConditionProperty() {
        return waterType;
    }

    private void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    public String toString() {
        return "Report Number: " + getReportNumber() + "\nReporter Name: " + getReporterName() + "\nDate Reported: " + getDateTime() + "\nLocation: " + getLocation().toString() + "\nWater Type: " + getWaterType() + "\nWater Condition: " + getWaterCondition();
    }

}
