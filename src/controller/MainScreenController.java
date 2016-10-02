package controller;

import cleanWaterApp.MainApp;
import javafx.fxml.FXML;
import model.User;

/**
 * Created by Elizabeth on 9/21/2016.
 */
public class MainScreenController {
    private MainApp mainApplication;
    private User user;

    /**
     * Connects the controller to the main app
     * @param mainApplication the main app
     */
    public void setMainApp(MainApp mainApplication) {
        this.mainApplication = mainApplication;
    }

    public void setUser(User user) {
        this.user = user;
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
