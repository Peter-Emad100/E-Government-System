package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.io.IOException;

public class editMinistryController {
    public Pane AddListView;
    public Button editMinistryButton;
    @FXML
    private TextField newMinistryNameField; // Input field for new ministry name

    private String oldMinistryName; // To store the ministry name from the first page

    public void setOldMinistryName(String oldName) {
        this.oldMinistryName = oldName;
        System.out.println("Old Ministry Name: " + oldMinistryName);  // Debugging line
    }

    @FXML
    private void onRenameMinistry() {
        String newName = newMinistryNameField.getText().trim();

        System.out.println(newName);
        if (newName == null || newName.isEmpty()) {
            String response = "New ministry name cannot be empty.";
            showAlert(response);
            newMinistryNameField.clear();
            return;
        }

        for (Ministry ministry : MinistriesCollection.getMinistries()) {
            if (ministry.getMinistryName().equalsIgnoreCase(newName.trim())) {
                String response = "Ministry name already exists.";
                showAlert(response);
                newMinistryNameField.clear();
                return;
            }
        }

        MinistriesCollection.edit(oldMinistryName, newName);
        String response = "Ministry name updated successfully!";
        showAlert(response);
        newMinistryNameField.clear();

        // Close current stage (editMinistryController window)
        Stage currentStage = (Stage) editMinistryButton.getScene().getWindow();
        currentStage.close();

        // Load the first controller (main window)
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMinistry.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Add/Remove Ministry");  // Change the title as needed
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error loading the first controller.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Operation Status");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
