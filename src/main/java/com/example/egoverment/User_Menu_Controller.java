package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class User_Menu_Controller {
    @FXML
    private FlowPane flowPane;

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

    public void initialize() {
        // Clear any existing content
        flowPane.getChildren().clear();

        List<String> fileno= new ArrayList<>();


        fileno.add("Ministry of Interior file"); // add department url when done
        fileno.add("Education.fxml");
        fileno.add("FinanceMinistry.fxml");
        fileno.add("Transportation.fxml");
        fileno.add("MinistryOfHealthAndPopulation.fxml");
        //ministry of electricity?? add it later when fixed





        // Loop through ministries
          int idx=0;
        for (Ministry ministry : MinistriesCollection.getMinistries()) {
            int finalIdx = idx;
            String ministryName = ministry.getMinistryName();
            Button ministryButton = new Button(ministryName);


            ministryButton.setPrefSize(200, 100);
            ministryButton.setStyle("-fx-font-size: 14px; -fx-background-color: #4682B4; -fx-text-fill: white;");

            // on action for each ministry buttons
            //edit idx to fit no. of ministries already developed if needed
            if(idx<=4) { // if its from the first few ministries load to the ministries page

                ministryButton.setOnAction(event -> {

                    try {
                        URL resource = getClass().getResource(fileno.get(finalIdx));
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
                });

                }
            else { // else load to its department page straight away(new ministries will be treated this way)
                ministryButton.setOnAction(event -> {

                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("put department fxml file page url"));

                        // Get the current stage from the event source
                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root); // Switch the root

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });
            }
                // Add the button to the FlowPane
                flowPane.getChildren().add(ministryButton);
            idx++;
            }


    }
}
