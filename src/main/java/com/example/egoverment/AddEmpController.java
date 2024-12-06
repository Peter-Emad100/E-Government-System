package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class AddEmpController {

    @FXML
    private Button AddMinistryButton;

    @FXML
    private TextField empid;

    @FXML
    private TextField empname;

    @FXML
    private ComboBox<String> ministryComboBox;

    @FXML
    private ComboBox<String> departmentComboBox;

    private ArrayList<Ministry> ministries;


    @FXML
    private void initialize() {
        // Retrieve ministries from the JSON file
        ministries = FileHelper.retrieve(new ArrayList<>(), "ministries", Ministry.class);

        if (ministries != null && !ministries.isEmpty()) {
            // Populate the ministry ComboBox
            for (Ministry ministry : ministries) {
                ministryComboBox.getItems().add(ministry.getMinistryName());
            }

            // Add a listener to populate departments based on the selected ministry
            ministryComboBox.setOnAction(event -> {
                String selectedMinistry = ministryComboBox.getValue();
                departmentComboBox.getItems().clear();

                for (Ministry ministry : ministries) {
                    if (ministry.getMinistryName().equals(selectedMinistry)) {
                        for (Department department : ministry.getDepartments()) {
                            departmentComboBox.getItems().add(department.getDepartmentName());
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
    private void addEmployee() {
        String selectedMinistry = ministryComboBox.getValue();
        String selectedDepartment = departmentComboBox.getValue();
        String employeeName = empname.getText();
        int employeeId = Integer.parseInt(empid.getText());
        try {
            employeeId = Integer.parseInt(empid.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Invalid Employee ID", "Please enter a valid number for Employee ID.");
            return;
        }
        if (selectedMinistry == null || selectedDepartment == null || employeeName.isEmpty() || employeeId==0) {
            // Show an error message or log
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Incomplete Fields", "Please fill in all required fields.");
            return;
        }

        // Find the selected ministry and department
        for (Ministry ministry : ministries) {
            if (ministry.getMinistryName().equals(selectedMinistry)) {
                for (Department department : ministry.getDepartments()) {
                    for (Employee employee : department.getEmployees()) {
                        if (employee.getId() == employeeId) {
                            showAlert(Alert.AlertType.WARNING, "Duplicate ID", "Employee ID Conflict", "An employee with this ID already exists. Please use a unique ID.");
                            return;
                        }
                    }
                    if (department.getDepartmentName().equals(selectedDepartment)) {
                        // Create a new employee
                        Employee newEmployee = new Employee(employeeName,employeeId);
                       /* newEmployee.setEmpName(employeeName);
                        newEmployee.setEmpId(employeeId);*/

                        // Add employee to the department
                        if (department.getEmployees() == null) {
                            department.setEmployees(new ArrayList<>());
                        }
                        department.getEmployees().add(newEmployee);

                        // Prepare and save the updated ministries back to the JSON file
                        FileHelper.prepareToSave(ministries, "ministries");
                        FileHelper.saveAll();

                        showAlert(Alert.AlertType.INFORMATION, "Success", "Employee Added", "The employee was added successfully!");
                        return;
                    }
                }
            }
        }

        System.out.println("Failed to find the specified department.");
    }
    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
