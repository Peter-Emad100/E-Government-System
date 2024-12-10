package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;

public class Owner_Menu_Controller {


        @FXML
        private Button manageMinistryButton;
        @FXML
        private Button addEmployeeButton;
        @FXML
        private Button removeEmployeeButton;
        @FXML
        private Button addFormButton;
        @FXML
        private Button removeFormButton;
        @FXML
        private Button logOutButton;
        @FXML
        private ImageView topImageView;


    @FXML
    private Label ministriesCountLabel;

    @FXML
    private Label usersCountLabel;

    // initialize no. of ministries and users
    @FXML
    public void initialize() {
        // Retrieve the number of ministries from the MinistryCollection
        int numberOfMinistries = Ministry.numberOfMinistries;

        // Retrieve the number of users directly from User class
        int numberOfUsers = User.numberOfUsers;

        // Update the labels
        ministriesCountLabel.setText("Number of Ministries: " + numberOfMinistries);
        usersCountLabel.setText("Number of Users: " + numberOfUsers);
    }


        // Action handler for 'Manage Ministry' button
        @FXML
        private void handleManageMinistryButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("AddMinistry.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }

        }

        // Action handler for 'Add Employee' button
        @FXML
        private void handleAddEmployeeButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("Add_Employee.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }

        }

        // Action handler for 'Remove Employee' button
        @FXML
        private void handleRemoveEmployeeButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("Remove_Employee.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }
        }

        // Action handler for 'Add Form' button
        @FXML
        private void handleManageFormButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("FormPage.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }

        }

    // Action handler for 'Add Department' button
    @FXML
    private void handleAddDepartmentButtonAction(ActionEvent event) {

        try {

            URL resource = getClass().getResource("AddDepartment.fxml");
            if (resource == null) {
                throw new IOException("FXML file not found: " );
            }

            Parent root = FXMLLoader.load(resource);

            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }

    }

    // Action handler for 'Remove Department' button
    @FXML
    private void handleRemoveDepartmentButtonAction(ActionEvent event) {

        try {

            URL resource = getClass().getResource("removeDepartment.fxml");
            if (resource == null) {
                throw new IOException("FXML file not found: " );
            }

            Parent root = FXMLLoader.load(resource);

            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }

    }


    @FXML
    private void HandleLogout(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("Loginer.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }



}


