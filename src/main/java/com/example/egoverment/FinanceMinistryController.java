package com.example.egoverment;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class FinanceMinistryController {
    @FXML
    private Label dataLabel;
    private String myData="hamed alsaqa";

    @FXML
    public void initialize() {
        // Set the Label text to the variable value
        try {

            myData =ExchangeRate.Formater(ExchangeRate.FetchRates());


        } catch (Exception e) {
            myData="Connection Failed \nLast updated: Mon, 02 Dec 2024 00:00:02 +0000 \n USD = 49.58 EGP \n EUR = 52.38 EGP \n JPY = 0.33 EGP \n GBP = 62.97 EGP \n" +
                    " CNY = 6.84 EGP \n AUD = 32.25 EGP \n CHF = 56.27 EGP \n HKD = 6.37 EGP \n SGD = 36.98 EGP";
        }

        dataLabel.setText(myData);
        System.out.println(dataLabel);
    }
}
