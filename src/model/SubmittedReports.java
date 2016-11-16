package model;

import controller.SerializationController;

import java.io.Serializable;
import java.util.ArrayList;


public class SubmittedReports implements Serializable {

    private static final SerializationController serController = SerializationController.getInstance();
    private static final ArrayList<Report> submittedReports = SerializationController.reports;

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
