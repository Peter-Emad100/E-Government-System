package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddEmpController{

    @FXML
    private Button AddMinistryButton;

    @FXML
    private TextField depname;

    @FXML
    private TextField empid;

    @FXML
    private TextField empname;
   /* public void addEmployee() {
        String departmentName = depname.getText();
        String employeeName = empname.getText();
        int employeeId = Integer.parseInt(empid.getText());

        Department department = MinistriesCollection.findDepartmentByName(departmentName);
        if (department == null) {
            showAlert("Error", "No department found with the given name.");
            return;
        }

        //add employee
        department.addEmployee(new Employee(employeeName,employeeId));
        showAlert("Success", "Employee added successfully to " + departmentName);
    }*/


    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}


