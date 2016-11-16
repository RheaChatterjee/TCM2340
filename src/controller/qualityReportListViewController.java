package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.WaterQualityReport;
import model.SubmittedQualityReports;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class qualityReportListViewController {

    private Stage _dialogStage;

    private final ArrayList<WaterQualityReport> reportArrayList = SubmittedQualityReports.getSubmittedQualityReports();

    @FXML
    private final ListView<String> qualityReportListView;


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
        ArrayList<WaterQualityReport> qualityReportsList = SerializationController.waterQualityReports;
        ArrayList<String> reportsAsStrings = qualityReportsList.stream().map(WaterQualityReport::toString).collect(Collectors.toCollection(ArrayList::new));

        qualityReportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
