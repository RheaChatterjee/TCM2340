package controller;

import cleanWaterApp.MainApp;
import javafx.fxml.FXML;

/**
 * Created by Elizabeth on 9/21/2016.
 */
public class MainScreenController {
    private MainApp mainApplication;

    /**
     * Connects the controller to the main app
     * @param mainApplication the main app
     */
    public void setMainApp(MainApp mainApplication) {
        this.mainApplication = mainApplication;
    }

    /**
     * shows the welcome screen
     */
    @FXML
    private void handleLogout() {
        //handle logout
        mainApplication.showWelcomeScreen();
    }
}
