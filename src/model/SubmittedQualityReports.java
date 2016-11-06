package model;

import java.util.ArrayList;


public class SubmittedQualityReports {
    private static final ArrayList<WaterQualityReport> submittedQualityReports = new ArrayList<>();


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
