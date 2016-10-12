package model;

import java.util.ArrayList;

/**
 * Created by Elizabeth on 10/6/2016.
 */
public class SubmittedReports {
    private static final ArrayList<Report> submittedReports = new ArrayList<>();

    public static ArrayList<Report> getSubmittedReports() {
        return submittedReports;
    }

    public void addReport(Report report) {
        submittedReports.add(report);
    }
}
