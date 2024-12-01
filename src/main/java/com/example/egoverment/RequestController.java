package com.example.egoverment;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class RequestController {
    Ministry ministries[]=new Ministry[2];
    public void initialize()
    {
        ministries[0] = new Ministry("Ministry of Interior", 0);
        ministries[0].departments.add(new Department("Department of Civil Status", 0));
        ministries[0].departments.add(new Department("Department of passports and immigration", 1));
        ministries[0].departments.get(0).forms.add(new Form("Changing SSN", 0));
        ministries[1]=new Ministry("Ministry of health", 1);
        ministries[1].departments.add(new Department("health", 0));

    }
    @FXML
    private Label outputLabel;

    @FXML
    private TextField addressField;

    @FXML
    private Button bckbutton;

    @FXML
    private DatePicker birthdateField;

    @FXML
    private TextField commentsField;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField idField;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private TextField nameField;

    @FXML
    private Button submitButton;

    private boolean gendertype;

    @FXML
    void SubmitRequest(MouseEvent event) {

        //gender knowing
        RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedText = selectedRadioButton.getText();
            if(selectedText.equals(maleRadio.getText()))
            {
                gendertype=true;
            }
            else {
                gendertype=false;
            }

        } else {
            outputLabel.setText("No option selected.");
        }

        //make sure that texts aren't submitted null except for comments
        if(addressField.getText() != null && !addressField.getText().trim().isEmpty()
                && nameField.getText() != null && !nameField.getText().trim().isEmpty()
                && idField.getText() != null && !idField.getText().trim().isEmpty()
                && birthdateField.getValue() != null)
        {
            ministries[0].departments.get(0).forms.get(0).requests.add(new Request(nameField.getText(), idField.getText(),
                    commentsField.getText(), addressField.getText(), birthdateField.getValue(), gendertype));
            System.out.println("heloooo");

        }


        System.out.println(ministries[0].departments.get(0).forms.get(0).requests.get(0).getBirthDate() +" "+
                ministries[0].departments.get(0).forms.get(0).requests.get(0).getId()+ " "+
                ministries[0].departments.get(0).forms.get(0).requests.get(0).getLocation()+ " "+
                ministries[0].departments.get(0).forms.get(0).requests.get(0).getName()+ " "+
                ministries[0].departments.get(0).forms.get(0).requests.get(0).getNotices());


    }





}
