package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Report;
import model.SubmittedReports;
import javafx.scene.control.ListView;
import model.User;

import java.util.ArrayList;

/**
 * Created by aminebenltaifa on 10/12/16.
 */
public class reportListViewController {

    private User user;

    private Stage _dialogStage;

    private ArrayList<Report> reportArrayList = SubmittedReports.getSubmittedReports();


    @FXML
    private ListView<String> reportListView;

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
            Report report = reportArrayList.get(i);
            reportsAsStrings.add(report.toString());
        }

        reportListView.setItems(FXCollections.observableArrayList(reportsAsStrings));
    }
}
