package com.example._2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculatorController {

    @FXML
    private TextField mainField;

    double xValue;
    double yValue;
    private String operator = "";

    private CalculatorModel calculatorModel = new CalculatorModel();
    private int doubleEqualFlag = 0;

    public void processNumberBtn(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        mainField.appendText(value);
    }

    public void processNumberMath(ActionEvent event) throws Exception {
        String value = ((Button)event.getSource()).getText();

        if(checkDoubleEqualFlag() && value.equals("="))
        {
            mainField.setText("");
            doubleEqualFlag = 0;
            xValue = 0;
            yValue = 0;
            operator = "";
            return;
        }

        switch (value) {
            case "+":
            case "-":
            case "*":
            case "/":
                operator = value;
                xValue = Double.parseDouble(mainField.getText());
                mainField.setText("");
                doubleEqualFlag = 0;
                break;
            case "=":
                yValue = Double.parseDouble((mainField.getText()));
                String val = calculatorModel.calculateValue(xValue, yValue, operator);

                xValue = Double.parseDouble(val);
                mainField.setText(val);

                doubleEqualFlag++;
                break;
        }
    }

    private boolean checkDoubleEqualFlag() {
        if(doubleEqualFlag == 1){
            return true;
        }
        return false;
    }
}