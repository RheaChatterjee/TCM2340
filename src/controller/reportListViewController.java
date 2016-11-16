package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Report;
import model.SubmittedReports;
import javafx.scene.control.ListView;
import model.User;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class reportListViewController {

    private Stage _dialogStage;

    private final ArrayList<Report> reportArrayList = SubmittedReports.getSubmittedReports();

    @FXML
    private final ListView<String> reportListView;

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
        ArrayList<Report> reportList = SerializationController.reports;
        ArrayList<String> reportsAsStrings = reportList.stream().map(Report::toString).collect(Collectors.toCollection(ArrayList::new));
        reportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
