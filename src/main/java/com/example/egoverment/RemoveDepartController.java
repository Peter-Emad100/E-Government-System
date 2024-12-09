package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class RemoveDepartController {

    @FXML
    private Button AddMinistryButton;

    @FXML
    private ComboBox<String> depname;

    @FXML
    private ComboBox<String> minname;

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
        //get ministries from ministries collection
        ministries = MinistriesCollection.getMinistries();

        if (ministries != null && !ministries.isEmpty()) {
            // fill ministry combobox
            for (Ministry ministry : ministries) {
                minname.getItems().add(ministry.getMinistryName());
            }

            // Add a listener to populate departments based on the selected ministry
            minname.setOnAction(event -> {
                String selectedMinistry = minname.getValue();
                depname.getItems().clear();

                for (Ministry ministry : ministries) {
                    if (ministry.getMinistryName().equals(selectedMinistry)) {
                        for (Department department : ministry.getDepartments()) {
                            depname.getItems().add(department.getDepartmentName());
                        }
                        break;
                    }
                }
            });
        } else {
            System.out.println("Failed to load ministries or no data found.");
        }
    }

    @FXML
    private void removeEmployee() {
        try {
            String selectedMinistry = minname.getValue();
            String depName = depname.getValue(); // Assuming depname is a ComboBox<String>

            if (selectedMinistry == null || depName == null) {
                showAlert(Alert.AlertType.WARNING, "Missing Input", "Incomplete Fields", "Please fill in all required fields.");
                return;
            }

            // Find the selected ministry
            for (Ministry ministry : ministries) {
                if (ministry.getMinistryName().equals(selectedMinistry)) {
                    // Find the department to remove
                    Department departmentToRemove = null;
                    for (Department department : ministry.getDepartments()) {
                        if (department.getDepartmentName().equals(depName)) {
                            departmentToRemove = department;
                            break;
                        }
                    }

                    if (departmentToRemove != null) {
                        ministry.getDepartments().remove(departmentToRemove);
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Department Removed", "The department was removed successfully!");
                        depname.getItems().remove(depName); // Update the UI
                    } else {
                        showAlert(Alert.AlertType.WARNING, "Not Found", "Department Not Found", "The selected department could not be found.");
                    }
                    return;
                }
            }

            showAlert(Alert.AlertType.WARNING, "Not Found", "Ministry Not Found", "The selected ministry could not be found.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred", e.getMessage());
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
