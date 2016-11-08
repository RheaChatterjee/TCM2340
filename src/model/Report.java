package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Report {

    private final StringProperty dateTime = new SimpleStringProperty();
    private final StringProperty reportNumber = new SimpleStringProperty();
    private final StringProperty reporterName = new SimpleStringProperty();
    private Location location = new Location();
    private final StringProperty waterType = new SimpleStringProperty();
    private final StringProperty waterCondition = new SimpleStringProperty();


    public Report() {
        DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy h:mm a");
        Date date = new Date();
        this.dateTime.set(date.toString());
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
        this.dateTime.set(date);
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
        return dateTime.get();
    }

    public StringProperty dateTimeProperty() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime.set(dateTime);
    }

    private String getReportNumber() {
        return reportNumber.get();
    }

    public StringProperty reportNumberProperty() {
        return reportNumber;
    }

    private void setReportNumber(String reportNumber) {
        this.reportNumber.set(reportNumber);
    }

    private String getReporterName() {
        return reporterName.get();
    }

    public StringProperty reporterNameProperty() {
        return reporterName;
    }

    private void setReporterName(String reporterName) {
        this.reporterName.set(reporterName);
    }

    public Location getLocation() {
        return location;
    }

    private void setLocation(Location location) {
        this.location = location;
    }

    private String getWaterType() {
        return waterType.get();
    }

    public StringProperty waterTypeProperty() {
        return waterType;
    }

    private void setWaterType(String waterType) {
        this.waterType.set(waterType);
    }

    private String getWaterCondition() {
        return waterCondition.get();
    }

    public StringProperty waterConditionProperty() {
        return waterType;
    }

    private void setWaterCondition(String waterCondition) {
        this.waterCondition.set(waterCondition);
    }

    public String toString() {
        return "Report Number: " + getReportNumber() + "\nReporter Name: " + getReporterName() + "\nDate Reported: " + getDateTime() + "\nLocation: " + getLocation().toString() + "\nWater Type: " + getWaterType() + "\nWater Condition: " + getWaterCondition();
    }

}
