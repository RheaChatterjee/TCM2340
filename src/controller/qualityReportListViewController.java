package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.WaterQualityReport;
import model.SubmittedQualityReports;
import model.User;

import java.util.ArrayList;


public class qualityReportListViewController {

    private Stage _dialogStage;

    private final ArrayList<WaterQualityReport> reportArrayList = SubmittedQualityReports.getSubmittedQualityReports();


    @FXML
    private ListView<String> qualityReportListView;


    /**
     * sets the dialog stage
     * @param dialogStage dialog stage
     */
    public void setDialogStage(Stage dialogStage) {
        this._dialogStage = dialogStage;
    }

    /**
     * closes dialog stage
     */
    public void handleCancel() {
        _dialogStage.close();
    }

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        ArrayList<String> reportsAsStrings = new ArrayList<>();
        for(WaterQualityReport r : reportArrayList) {
            reportsAsStrings.add(r.toString());
        }

        qualityReportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
