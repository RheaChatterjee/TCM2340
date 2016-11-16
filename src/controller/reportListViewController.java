package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Report;
import model.SubmittedReports;
import javafx.scene.control.ListView;
import model.User;

import java.util.ArrayList;


public class reportListViewController {

    private Stage _dialogStage;

    private final ArrayList<Report> reportArrayList = SubmittedReports.getSubmittedReports();

    @FXML
    private ListView<String> reportListView;

    /**
     * sets the user
     * @param user the logged in user
     */
    public void setUser(User user) {
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
        SerializationController serController = SerializationController.getInstance();
        serController.retrieveChanges("reports");
        ArrayList<Report> reportList = serController.reports;
        ArrayList<String> reportsAsStrings = new ArrayList<>();
        for (Report report : reportList) {
            reportsAsStrings.add(report.toString());
        }
        reportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
