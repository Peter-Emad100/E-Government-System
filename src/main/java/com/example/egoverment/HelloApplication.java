package com.example.egoverment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Loginer.fxml"));
            Pane root = (Pane) loader.load();
            //Create a scene and set the stage
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("");
            primaryStage.show();

            //Access the controller if needed
            Loginer_Controller controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    public static void main (String[] args){

        FileHelper.retrieveAll();
        launch(args);
        FileHelper.saveAll();

    }
}
