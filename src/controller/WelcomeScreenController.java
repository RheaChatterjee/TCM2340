package controller;

import cleanWaterApp.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Elizabeth on 9/17/2016.
 */
public class WelcomeScreenController {

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    private MainApp mainApplication;

    @FXML
    private void initialize() {
        loginButton.setOnAction((e) -> {
            //loginButton was clicked
        });
    }

    public void setMainApp(MainApp main) {
        mainApplication = main;
    }

    @FXML
    private void handleLogin(ActionEvent e) {

    }


}
