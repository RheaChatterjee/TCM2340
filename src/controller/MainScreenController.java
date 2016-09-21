package controller;

import cleanWaterApp.MainApp;
import javafx.fxml.FXML;

/**
 * Created by Elizabeth on 9/21/2016.
 */
public class MainScreenController {
    private MainApp mainApplication;

    public void setMainApp(MainApp mainApplication) {
        this.mainApplication = mainApplication;
    }


    @FXML
    private void handleLogout() {
        //handle logout
        mainApplication.showWelcomeScreen();
    }
}
