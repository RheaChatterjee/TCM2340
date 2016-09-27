package controller;

import cleanWaterApp.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.User;

/**
 * Created by Elizabeth on 9/17/2016.
 */
public class WelcomeScreenController {


    private MainApp mainApplication;

    /**
     * Connects the controller to the main application
     * @param mainApplication the main app
     */
    public void setMainApp(MainApp mainApplication) {
        this.mainApplication = mainApplication;
    }


    /**
     * shows the login window
     */
    @FXML
    private void handleLogin() {
        //handle login
        User tempUser = new User();
        mainApplication.showLoginWindow(tempUser);
    }




}
