package com.example._2;

public class CalculatorModel {

    public String calculateValue(double x, double y, String operator) throws Exception {
        double res;
        if(operator.equals("+")){
            res = x + y;
        }
        else if(operator.equals("-")){
            res = x - y;
        }
        else if(operator.equals("*")){
            res = x * y;
        }
        else if(operator.equals("/")){
            res = x / y;
        }
        else {
            throw new Exception("Unknown operator");
        }

        return String.valueOf(res);
    }
}
