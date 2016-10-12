package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import model.Report;
import model.SubmittedReports;
import javafx.scene.control.ListView;
import java.util.ArrayList;

/**
 * Created by aminebenltaifa on 10/12/16.
 */
public class reportListViewController {

    private ArrayList<Report> reportArrayList = SubmittedReports.getSubmittedReports();


    @FXML
    private ListView<String> reportListView;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        ArrayList<String> reportsAsStrings = new ArrayList<>();
        for(int i = 0; i < reportArrayList.size(); i++) {
            Report report = reportArrayList.get(i);
            reportsAsStrings.add(report.toString());
        }

        reportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
