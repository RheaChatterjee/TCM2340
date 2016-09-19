package controller;

import cleanWaterApp.MainApp;
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

    public void setMainApp(MainApp main) {
        mainApplication = main;
    }


}
