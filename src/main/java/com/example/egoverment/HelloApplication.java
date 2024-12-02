//package com.example.egoverment;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        try {
//            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Education.fxml"));
//            Pane root = (Pane) loader.load();
//            // Create a scene and set the stage
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("");
//            primaryStage.show();
//
//            // Access the controller if needed
//            Electricity_Controller controller = loader.getController();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Failed to load FXML. Check the file path.");
//        }
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

package com.example.egoverment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML file for the Ministry of Electricity layout
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("FinanceMinistry.fxml"));
            Pane root = (Pane) loader.load();
            // Create a scene and set the stage
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("E-government System");
            primaryStage.show();
            MinistryOfHealthAndPopulation healthMinistry = HealthMinistryDataTest.initializeHealthMinistry();

            // Access the controller if needed
            //RequestController controller = loader.getController();
            FinanceMinistryController controller=loader.getController();
            // You can call methods of the controller here if needed
            //controller.setMinistry(healthMinistry);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
