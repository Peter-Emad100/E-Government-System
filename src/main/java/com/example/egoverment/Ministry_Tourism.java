package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class Ministry_Tourism {

    @FXML
    private ImageView tut;

    @FXML
    private ImageView tut1;

    @FXML
    private ImageView tut11;

    @FXML
    private ImageView tut111;

    @FXML
    private ImageView tut1111;

    @FXML
    private ImageView tut11111;

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
    private void reroot(ActionEvent event)
    {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("showDepartments.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }


}
