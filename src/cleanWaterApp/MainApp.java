package cleanWaterApp;

import controller.LoginController;
import controller.MainScreenController;
import controller.WelcomeScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends Application {

    /**  the java logger for this class */
    private static final Logger LOGGER =Logger.getLogger("cleanWaterApp");

    /** the main container for the application window */
    private Stage mainScreen;

    /** the main layout for the main window */
    private GridPane rootLayout;


    @Override
    public void start(Stage primaryStage) throws Exception{
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
    }

    /**
     * Gets main screen
     * @return main screen
     */
    public Stage getMainScreen() { return mainScreen;}

    /**
     * initializes original scene
     * @param mainScreen
     */
    private void initRootLayout(Stage mainScreen) {
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/welcome.fxml"));
            rootLayout = loader.load();


            WelcomeScreenController controller = loader.getController();
            controller.setMainApp(this);


            // Set the cleanWaterApp App title
            mainScreen.setTitle("Welcome");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for WelcomeScreen!!");
            e.printStackTrace();
        }
    }

    /**
     * launches application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * shows welcome screen
     */
    public void showWelcomeScreen() {
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/welcome.fxml"));
            GridPane layout = loader.load();

            WelcomeScreenController controller = loader.getController();
            controller.setMainApp(this);

            // Set the cleanWaterApp App title
            mainScreen.setTitle("Welcome Screen");

            // Show the scene containing the root layout.
            Scene scene = new Scene(layout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for WelcomeScreen!!");
            e.printStackTrace();
        }
    }

    /**
     * shows main screen
     */
    public void showMainScreen() {
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/mainScreen.fxml"));
            GridPane layout = loader.load();

            MainScreenController controller = loader.getController();
            controller.setMainApp(this);

            // Set the cleanWaterApp App title
            mainScreen.setTitle("Main Screen");

            // Show the scene containing the root layout.
            Scene scene = new Scene(layout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for WelcomeScreen!!");
            e.printStackTrace();
        }
    }

    /**
     * shows login window
     * @param user
     */
    public void showLoginWindow(User user) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/login.fxml"));
            AnchorPane page = loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Login");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            LoginController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setUser(user);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            if (controller.is_login()) {
                showMainScreen();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
