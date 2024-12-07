package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RemoveEmpController {

    @FXML
    private Button AddMinistryButton;

    @FXML
    private ComboBox<String> depname;

    @FXML
    private TextField empid;

    @FXML
    private ComboBox<String> minname;

    private ArrayList<Ministry> ministries;


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
            String selectedDepartment = depname.getValue();
            int employeeId;

            try {
                employeeId = Integer.parseInt(empid.getText());
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Invalid Employee ID", "Please enter a valid number for Employee ID.");
                return;
            }

            if (selectedMinistry == null || selectedDepartment == null || employeeId == 0) {
                showAlert(Alert.AlertType.WARNING, "Missing Input", "Incomplete Fields", "Please fill in all required fields.");
                return;
            }

            for (Ministry ministry : ministries) {
                if (ministry.getMinistryName().equals(selectedMinistry)) {
                    for (Department department : ministry.getDepartments()) {
                        for (Employee employee : department.getEmployees()) {
                            if (employee.getId() == employeeId) {
                                department.getEmployees().remove(employee);
                                showAlert(Alert.AlertType.INFORMATION, "Success", "Employee Removed", "The employee was removed successfully!");
                                return;
                            }
                        }
                    }
                }
            }

            showAlert(Alert.AlertType.WARNING, "Not Found", "Employee Not Found", "The specified employee was not found.");
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

