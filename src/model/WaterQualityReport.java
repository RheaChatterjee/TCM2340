package model;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaterQualityReport implements Serializable {
    private String dateTime = "";
    private String reportNumber = "";
    private String reporterName = "";
    private Location location = new Location();
    private String waterCondition = "";
    private String virusPPM = "";
    private String contamPPM = "";


    public WaterQualityReport() {
        DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy h:mm a");
        this.dateTime = dateFormat.format(new Date());
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
        this.dateTime = dateFormat.format(new Date());
    }

    /**
     * gets the year of the report
     * @return String of the year
     */
    public String getYear() {
        return getDateTime().substring(7, 11);
    }

    /**
     * gets the year of the report
     * @return String of the year
     */
    public String getMonth() {
        return getDateTime().substring(0, 3);
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

    private String getWaterCondition() {
        return waterCondition;
    }

    private void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    public String getVirusPPM() {
        return virusPPM;
    }

    public String virusPPMProperty() {
        return virusPPM;
    }

    private void setVirusPPM(String virusPPM) {
        this.virusPPM = virusPPM;
    }

    public String getContamPPM() {
        return contamPPM;
    }

    public String contamPPMProperty() {
        return contamPPM;
    }

    private void setContamPPM(String contamPPM) {
        this.contamPPM = contamPPM;
    }

    public String toString() {
        return "Report Number: " + getReportNumber() + "\nReporter Name: " + getReporterName() + "\nDate Reported: " + getDateTime() + "\nLocation: " + getLocation().toString() + "\nWater Condition: " + getWaterCondition() + "\nVirusPPM: " + getVirusPPM() + "\nContamPPM: " + getContamPPM();
    }

}
