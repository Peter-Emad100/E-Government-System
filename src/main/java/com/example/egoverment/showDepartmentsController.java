package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;


public class showDepartmentsController {
    private String Currentministry= User_Menu_Controller.Currentministry;
    private String ministryName_controller = User_Menu_Controller.ministryName_controller;

    private ArrayList<Ministry> ministries = MinistriesCollection.getMinistries();

    private ArrayList<Department> departments;

    public static String selectedForm;

    @FXML
    private ComboBox<String> departmentIn;
    @FXML
    private ComboBox<String> formIn;

    @FXML
    private Button loadFormsButton;

    @FXML
    private void initializeDepartments() {
        for (Ministry ministry : ministries) {
            if (this.ministryName_controller.equals(ministry.getMinistryName())) {
                departments = ministry.getDepartments();
                break;
            }
        }

        populateDepartmentsComboBox();
    }

    @FXML
    private void Back(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource(Currentministry));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    @FXML
    private void populateDepartmentsComboBox() {
        if (departments != null && !departments.isEmpty()) {
            for (Department department : departments) {
                departmentIn.getItems().add(department.getDepartmentName());
            }
        } else {
            System.out.println("No departments available for this ministry.");
        }

        // Add a listener to the department ComboBox
        departmentIn.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    populateFormsComboBox(newValue); // Populate forms based on selected department
                }
            }
        });
    }

    private void populateFormsComboBox(String departmentName) {
        formIn.getItems().clear(); // Clear previous forms
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                for (Form form : department.forms) { // Assuming forms is a public field in Department
                    formIn.getItems().add(form.getFormName());
                }
                break;
            }
        }
    }

    @FXML
    void handleLoadRequestPage(MouseEvent event) {
        try {
            // Check if a form is selected
            selectedForm = formIn.getValue(); // Get the selected form
            System.out.println(selectedForm);

            if (selectedForm == null || selectedForm.isEmpty()) {
                // Show an alert if no form is selected
                showAlert("Error", "Please select a form before proceeding.", Alert.AlertType.ERROR);
                return; // Don't proceed if no form is selected
            }

            try {
                // Load the FXML for the primary stage images page
                Parent root = FXMLLoader.load(getClass().getResource("requestpage.fxml"));

                // Get the current stage from the event source
                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root); // Switch the root
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }

        } catch (Exception e) {
            // Handle any unexpected errors and show an alert
            showAlert("Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void initialize() {

        initializeDepartments(); // Initialize departments on page load
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
