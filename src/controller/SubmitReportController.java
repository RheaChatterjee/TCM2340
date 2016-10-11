package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.User;

/**
 * Created by Elizabeth on 10/11/2016.
 */
public class SubmitReportController {
    private User user;

    private Stage _dialogStage;

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * sets the dialog stage
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }
    /**
     * closes the window if the canceled button is pressed
     */
    @FXML
    private void handleCancelPressed() {
        _dialogStage.close();
    }
}
