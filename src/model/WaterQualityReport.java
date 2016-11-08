package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaterQualityReport {
    private final StringProperty dateTime = new SimpleStringProperty();
    private final StringProperty reportNumber = new SimpleStringProperty();
    private final StringProperty reporterName = new SimpleStringProperty();
    private Location location = new Location();
    private final StringProperty waterType = new SimpleStringProperty();
    private final StringProperty waterCondition = new SimpleStringProperty();
    private final StringProperty virusPPM = new SimpleStringProperty();
    private final StringProperty contamPPM = new SimpleStringProperty();


    public WaterQualityReport() {
        DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy h:mm a");
        Date date = new Date();
        this.dateTime.set(date.toString());
    }

    public WaterQualityReport(String reporterName, Location location, String waterCondition, String virusPPM, String contamPPM) {
        SubmittedQualityReports submittedReports = new SubmittedQualityReports();
        setReportNumber(String.format("%05d", submittedReports.getQualityArraySize() + 1));
        setReporterName(reporterName);
        setLocation(location);
        setWaterCondition(waterCondition);
        setVirusPPM(virusPPM);
        setContamPPM(contamPPM);
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

    /**
     * gets the year of the report
     * @return String of the year
     */
    public String getMonth() {
        String month = getDateTime().substring(0, 3);
        return month;
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

    private String getWaterCondition() {
        return waterCondition.get();
    }

    public StringProperty waterConditionProperty() {
        return waterType;
    }

    private void setWaterCondition(String waterCondition) {
        this.waterCondition.set(waterCondition);
    }

    public String getVirusPPM() {
        return virusPPM.get();
    }

    public StringProperty virusPPMProperty() {
        return virusPPM;
    }

    private void setVirusPPM(String virusPPM) {
        this.virusPPM.set(virusPPM);
    }

    public String getContamPPM() {
        return contamPPM.get();
    }

    public StringProperty contamPPMProperty() {
        return contamPPM;
    }

    private void setContamPPM(String contamPPM) {
        this.contamPPM.set(contamPPM);
    }

    public String toString() {
        return "Report Number: " + getReportNumber() + "\nReporter Name: " + getReporterName() + "\nDate Reported: " + getDateTime() + "\nLocation: " + getLocation().toString() + "\nWater Condition: " + getWaterCondition() + "\nVirusPPM: " + getVirusPPM() + "\nContamPPM: " + getContamPPM();
    }

}
