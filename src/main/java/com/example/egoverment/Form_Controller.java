package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Form_Controller {

    @FXML
    private TextField ministryTextField;

    @FXML
    private TextField departmentTextField;

    @FXML
    private TextField formNameTextField;

    @FXML
    private Button addFormButton;

    @FXML
    private Button removeFormButton;

    private ArrayList<Ministry> ministries;

    @FXML
    public void initialize() {
        ministries = MinistriesCollection.getMinistries();
    }

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
    private void addFormButton(ActionEvent event) {
        String ministryName = ministryTextField.getText().trim();
        String departmentName = departmentTextField.getText().trim();
        String formName = formNameTextField.getText().trim();

        // Check for empty fields
        if (ministryName.isEmpty() || departmentName.isEmpty() || formName.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Invalid Input", "Missing Fields", "Please fill out all fields!");
            return;
        }

        for (Ministry ministry : ministries) {
            // Check if ministry matches
            if (ministry.getMinistryName().equalsIgnoreCase(ministryName)) {
                if (ministry.getDepartments() != null)
                    // Loop through departments to find the specified department
                    for (Department department : ministry.getDepartments()) {
                        // Check if department matches
                        if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {

                            // Check if form already exists in the department
                            for (Form form : department.getforms()) {
                                if (form.getFormName().equalsIgnoreCase(formName)) {
                                    showAlert(Alert.AlertType.WARNING, "Duplicate Form", "Form already exists", "The form you are trying to add already exists!");
                                    return;
                                }
                            }

                            // Create a new form if it doesn't exist
                            Form newForm = new Form(formName);

                            // Add form to the department's forms list
                            if (department.getforms() == null) {
                                department.setForms(new ArrayList<>());
                            }
                            department.getforms().add(newForm);

                            // Success message after form is added
                            showAlert(Alert.AlertType.INFORMATION, "Success", "Form Added", "The form was added successfully!");
                            clearFields();
                            return; // Stop execution after adding the form
                        }
                    }

                // If the specified department is not found within the ministry
                showAlert(Alert.AlertType.WARNING, "Department Not Found", "Invalid Department", "The specified department does not exist in this ministry.");
                return;
            }
        }

        // If the specified ministry is not found
        showAlert(Alert.AlertType.WARNING, "Ministry Not Found", "Invalid Ministry", "The specified ministry does not exist.");
    }

    @FXML
    private void removeFormButton(ActionEvent event) {
        String ministryName = ministryTextField.getText().trim();
        String departmentName = departmentTextField.getText().trim();
        String formName = formNameTextField.getText().trim();

        if (ministryName.isEmpty() || departmentName.isEmpty() || formName.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Invalid Input", "Missing Fields", "Please fill out all fields!");
            return;
        }

        for (Ministry ministry : ministries) {
            if (ministry.getMinistryName().equalsIgnoreCase(ministryName)) {
                for (Department department : ministry.getDepartments()) {
                    if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {
                        // Use the instance method `getForms()` to check for the form
                        for (Form form : department.getforms()) {
                            if (form.getFormName().equalsIgnoreCase(formName)) {
                                department.removeForm(formName); // Remove the form using the method in Department
                                showAlert(Alert.AlertType.INFORMATION, "Success", "Form Removed", "The form was removed successfully!");
                                clearFields();
                                return;
                            }
                        }
                        showAlert(Alert.AlertType.WARNING, "Form Not Found", "Invalid Form", "The specified form does not exist in this department.");
                        return;
                    }
                }
                showAlert(Alert.AlertType.WARNING, "Department Not Found", "Invalid Department", "The specified department does not exist in this ministry.");
                return;
            }
        }
        showAlert(Alert.AlertType.WARNING, "Ministry Not Found", "Invalid Ministry", "The specified ministry does not exist.");
    }

    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearFields() {
        ministryTextField.clear();
        departmentTextField.clear();
        formNameTextField.clear();
    }
}
