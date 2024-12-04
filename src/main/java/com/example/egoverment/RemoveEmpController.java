package com.example.egoverment;


    import javafx.fxml.FXML;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemoveEmpController {

        @FXML
        private Button AddMinistryButton;

        @FXML
        private TextField depname;

        @FXML
        private TextField empid;

    public void removeEmployee() {
        String departmentName = depname.getText();
        int employeeId;

        try {
            employeeId = Integer.parseInt(empid.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Employee ID must be a number.");
            return;
        }

        Department department = MinistriesCollection.findDepartmentByName(departmentName);
        if (department == null) {
            showAlert("Error", "No department found with the given name.");
            return;
        }

        boolean removed = department.removeEmployee(employeeId);
        if (removed) {
            showAlert("Success", "Employee removed successfully from " + departmentName);
        } else {
            showAlert("Error", "Employee not found in " + departmentName);
        }
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}


