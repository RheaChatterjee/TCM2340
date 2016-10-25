package model;

import java.util.ArrayList;

/**
 * Created by Elizabeth on 10/6/2016.
 */
public class SubmittedReports {
    private static final ArrayList<Report> submittedReports = new ArrayList<>();

    /**
     * gets the submitted reports
     * @return ArrayList returns the submitted reports
     */
    public static ArrayList<Report> getSubmittedReports() {
        return submittedReports;
    }

    /**
     * gets the size of the array
     * @return int size of the array
     */
    public int getArraySize() {
        return submittedReports.size();
    }

    /**
     * adds report to the final array list
     * @param report the report to be added
     */
    public void addReport(Report report) {
        submittedReports.add(report);
    }
}
