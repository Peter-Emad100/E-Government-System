package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Education_Controller {

    @FXML
    private void Backtomenu(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("User_MainMenu.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    @FXML
    private void showPrimaryStageImage(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("PrimaryStageImages.fxml"));


            // Get the current stage (window) from the back button action
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded Education.fxml root
            Scene scene = new Scene(root);
            stage.setScene(scene);  // Set the scene to Education.fxml
            stage.show();  // Show the Education scene

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    @FXML
    private void showPreparatoryStageImage(ActionEvent event) {
        try {
            // Load the FXML for the preparatory stage images page
            Parent root = FXMLLoader.load(getClass().getResource("PreparatoryStageImages.fxml"));


            // Get the current stage (window) from the back button action
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded Education.fxml root
            Scene scene = new Scene(root);
            stage.setScene(scene);  // Set the scene to Education.fxml
            stage.show();  // Show the Education scene

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    @FXML
    private void showSecondaryStageImage(ActionEvent event) {
        try {
            // Load the FXML for the secondary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("SecondaryStageImages.fxml"));

            // Get the current stage (window) from the back button action
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded Education.fxml root
            Scene scene = new Scene(root);
            stage.setScene(scene);  // Set the scene to Education.fxml
            stage.show();  // Show the Education scene

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }
    @FXML
    private void handleBackAction(ActionEvent event) {
        try {
            // Load the Education.fxml
            Parent root = FXMLLoader.load(getClass().getResource("Education.fxml"));

            // Get the current stage (window) from the back button action
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded Education.fxml root
            Scene scene = new Scene(root);
            stage.setScene(scene);  // Set the scene to Education.fxml
            stage.show();  // Show the Education scene

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    private void BackToMenu(ActionEvent event) {
        try {
            // Load the Education.fxml
            Parent root = FXMLLoader.load(getClass().getResource("Education.fxml"));

            // Get the current stage (window) from the back button action
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded Education.fxml root
            Scene scene = new Scene(root);
            stage.setScene(scene);  // Set the scene to Education.fxml
            stage.show();  // Show the Education scene

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }
}
