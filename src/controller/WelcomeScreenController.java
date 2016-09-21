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

    public void setMainApp(MainApp mainApplication) {
        this.mainApplication = mainApplication;
    }


    @FXML
    private void handleLogin() {
        //handle login
        User tempUser = new User();
        mainApplication.showLoginWindow(tempUser);
    }




}
