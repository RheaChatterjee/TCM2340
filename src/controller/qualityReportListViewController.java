package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.WaterQualityReport;
import model.SubmittedQualityReports;
import model.User;

import java.util.ArrayList;

/**
 * Created by RheaChatterjee on 10/30/16.
 */
public class qualityReportListViewController {
    private User user;

    private Stage _dialogStage;

    private ArrayList<WaterQualityReport> reportArrayList = SubmittedQualityReports.getSubmittedQualityReports();


    @FXML
    private ListView<String> reportListView;

    /**
     * sets the user
     * @param user the logged in user
     */
    public void setUser(User user) {
        this.user = user;
    }

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
        for(int i = 0; i < reportArrayList.size(); i++) {
            WaterQualityReport report = reportArrayList.get(i);
            reportsAsStrings.add(report.toString());
        }

        reportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
