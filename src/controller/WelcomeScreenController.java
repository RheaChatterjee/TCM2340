package controller;

import cleanWaterApp.MainApp;
import javafx.fxml.FXML;
import model.User;


public class WelcomeScreenController {


    private MainApp mainApplication;

    private User user;

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

    /**
     * shows the login window
     */
    @FXML
    private void handleRegistration() {
        //handle registration
        mainApplication.showRegistrationWindow();
    }






}
