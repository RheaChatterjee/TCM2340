package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Elizabeth on 9/20/2016.
 */
public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    /** the window for this dialog */
    private Stage _dialogStage;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }


    @FXML
    private void handleCancelPressed() {
        _dialogStage.close();
    }


}
