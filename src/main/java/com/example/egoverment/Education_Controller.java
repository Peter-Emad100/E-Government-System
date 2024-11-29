package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Education_Controller {

    @FXML
    private void showPrimaryStageImage() {
        try {
            // Load the FXML for the primary stage images page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PrimaryStageImages.fxml"));
            ScrollPane root = loader.load();  // Correct cast to ScrollPane

            // Create a new scene for the primary stage and show it
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Primary Stage Exams");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showPreparatoryStageImage() {
        try {
            // Load the FXML for the preparatory stage images page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PreparatoryStageImages.fxml"));
            AnchorPane root = loader.load();  // AnchorPane is used here

            // Create a new scene for the preparatory stage and show it
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Preparatory Stage Images");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showSecondaryStageImage() {
        try {
            // Load the FXML for the secondary stage images page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondaryStageImages.fxml"));
            AnchorPane root = loader.load();  // AnchorPane is used here

            // Create a new scene for the secondary stage and show it
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Secondary Stage Images");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}