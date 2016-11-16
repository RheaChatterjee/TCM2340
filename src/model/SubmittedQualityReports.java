package model;

import controller.SerializationController;

import java.io.Serializable;
import java.util.ArrayList;


public class SubmittedQualityReports implements Serializable {

    private static final SerializationController serController = SerializationController.getInstance();

    private static final ArrayList<WaterQualityReport> submittedQualityReports = SerializationController.waterQualityReports;


    /**
     * gets the submitted water quality reports
     * @return ArrayList returns the submitted water quality reports
     */
    public static ArrayList<WaterQualityReport> getSubmittedQualityReports() {
        return submittedQualityReports;
    }

    /**
     * gets the size of the water quality report array
     * @return int size of the water quality report array
     */
    public int getQualityArraySize() {
        return submittedQualityReports.size();
    }

    /**
     * ad8ds water quality report to the final array list
     * @param report the report to be added
     */
    public void addQualityReport(WaterQualityReport report) {
        submittedQualityReports.add(report);
    }

}
