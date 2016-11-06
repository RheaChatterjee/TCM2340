package controller;

import cleanWaterApp.MainApp;
import javafx.fxml.FXML;
import model.User;


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

    /**
     * shows the edit profile screen
     */
    @FXML
    private void handleEditProfile() {
        mainApplication.showEditProfile();
    }

    /**
     * shows the user profile screen
     */
    @FXML
    private void handleUserProfile() {
        mainApplication.showUserProfile();
    }

    @FXML
    private void openMap() {
        mainApplication.showMap(user);
    }

    @FXML
    private void openSubmitReportPage() {
        mainApplication.showReportPage();
    }

    @FXML
    private void openSubmitQualityReportPage() {
        mainApplication.showQualityReportPage();
    }

    @FXML
    private void handleViewSubmittedReports() {
        mainApplication.showSubmittedReports();
    }

    @FXML
    private void handleViewSubmittedQualityReports() {
        mainApplication.showSubmittedQualityReports();
    }
}
