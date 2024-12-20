package com.example.egoverment;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class FinanceMinistryController {
    @FXML
    private Label dataLabel;
    private String myData="hamed alsaqa";

    @FXML
    private void reroot(ActionEvent event)
    {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("showDepartments.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    @FXML
    private void Backtomenu(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("User_MainMenu.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    @FXML
    public void initialize() {
        // Set the Label text to the variable value
        try {

            myData =ExchangeRate.Formater(ExchangeRate.FetchRates());


        } catch (Exception e) {
            myData="Connection Failed \nLast updated: Fri, 20 Dec 2024 00:00:02 +0000 \n USD = 50.89 EGP \n EUR = 52.91 EGP \n JPY = 0.32 EGP \n GBP = 64.23 EGP \n" +
                    " CNY = 6.96 EGP \n AUD = 31.77 EGP \n CHF = 56.69 EGP \n HKD = 6.55 EGP \n SGD = 37.43 EGP";
        }

        dataLabel.setText(myData);
        System.out.println(dataLabel);
    }
}
