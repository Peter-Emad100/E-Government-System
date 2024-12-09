package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class AddDepartmentController {

    @FXML
    private Button AddButton;

    @FXML
    private ImageView background;

    @FXML
    private TextField depname;

    @FXML
    private ComboBox<String> ministryComboBox;
    private ArrayList<Ministry>ministries;
    @FXML
    private void Backtomenu(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("Owner_MainMenu.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    @FXML
    private void initialize() {
        ministries = MinistriesCollection.getMinistries();

        if (ministries != null && !ministries.isEmpty()) {
            for (Ministry ministry : ministries) {
                ministryComboBox.getItems().add(ministry.getMinistryName());
            }
        } else {
            System.out.println("Failed to load ministries or no data found.");
        }

        ministryComboBox.setOnAction(event -> {
            String selectedMinistry = ministryComboBox.getValue();
        });
    }

    @FXML
    private void addEmployee() {
        String selectedMinistry = ministryComboBox.getValue();
        String depName = depname.getText();

        if (selectedMinistry == null  || depName.isEmpty() ) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Incomplete Fields", "Please fill in all required fields.");
            return;
        }

        // Find the selected ministry
        for (Ministry ministry : ministries) {
            if (ministry.getMinistryName().equals(selectedMinistry)) {
                for (Department department : ministry.getDepartments()) {
                    if (department.getDepartmentName().equals(depName)) {
                        showAlert(Alert.AlertType.WARNING, "Department already exists", "Department already exists", "Please Enter another department");
                        return;
                    }
                }

                Department newdep = new Department(depName);
                ministry.getDepartments().add(newdep);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Department Added", "The department was added successfully!");
                return;
            }else{
            System.out.println("Failed to find the specified Ministry");
            }
        }

    }


private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
