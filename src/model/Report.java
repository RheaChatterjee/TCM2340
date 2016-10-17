package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.SubmittedReports;

/**
 * Created by Elizabeth on 10/6/2016.
 */
public class Report {

    private final StringProperty dateTime = new SimpleStringProperty();
    private final StringProperty reportNumber = new SimpleStringProperty();
    private final StringProperty reporterName = new SimpleStringProperty();
    private final StringProperty location = new SimpleStringProperty();
    private final StringProperty waterType = new SimpleStringProperty();
    private final StringProperty waterCondition = new SimpleStringProperty();
    private SubmittedReports submittedReports = new SubmittedReports();


    public Report() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
        Date date = new Date();
        this.dateTime.set(date.toString());
    }

    public Report(String reporterName, String location, String waterType, String waterCondition) {
        setReportNumber(String.format("%05d", submittedReports.getArraySize() + 1));
        setReporterName(reporterName);
        setLocation(location);
        setWaterType(waterType);
        setWaterCondition(waterCondition);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
        Date date = new Date();
        this.dateTime.set(date.toString());
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public StringProperty dateTimeProperty() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime.set(dateTime);
    }

    public String getReportNumber() {
        return reportNumber.get();
    }

    public StringProperty reportNumberProperty() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber.set(reportNumber);
    }

    public String getReporterName() {
        return reporterName.get();
    }

    public StringProperty reporterNameProperty() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName.set(reporterName);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getWaterType() {
        return waterType.get();
    }

    public StringProperty waterTypeProperty() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType.set(waterType);
    }

    public String getWaterCondition() {
        return waterCondition.get();
    }

    public StringProperty waterConditionProperty() {
        return waterType;
    }

    public void setWaterCondition(String waterCondition) {
        this.waterCondition.set(waterCondition);
    }

    public String toString() {
        return "Report Number: " + getReportNumber() + "\nReporter Name: " + getReporterName() + "\nDate Reported: " + getDateTime() + "\nLocation: " + getLocation() + "\nWater Type: " + getWaterType() + "\nWater Condition: " + getWaterCondition();
    }

}
