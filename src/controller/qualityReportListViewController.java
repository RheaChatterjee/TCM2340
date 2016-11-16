package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Report;
import model.WaterQualityReport;
import model.SubmittedQualityReports;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class qualityReportListViewController {

    private Stage _dialogStage;

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
        SerializationController serController = SerializationController.getInstance();
        serController.retrieveChanges("waterQualityReports");
        ArrayList<WaterQualityReport> qualityReportsList = serController.waterQualityReports;
        ArrayList<String> reportsAsStrings = new ArrayList<>();
        for (WaterQualityReport x : qualityReportsList) {
            reportsAsStrings.add(x.toString());
        }
        qualityReportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
