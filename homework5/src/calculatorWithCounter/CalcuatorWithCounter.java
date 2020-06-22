package calculatorWithCounter;

import calculatorWithOperator.CalcInterface;
import calculatorWithOperator.CalculatorWithOperator;

public class CalcuatorWithCounter {
    private CalcInterface calculator;
    private int countOperation;

    public CalcuatorWithCounter(CalcInterface calculator) {
        this.calculator = calculator;
        countOperation = 0;
    }

    public double sum(double a, double b) {
        countOperation++;
        return calculator.sum(a, b);
    }

    public double subtract(double a, double b) {
        countOperation++;
        return calculator.subtract(a, b);
    }

    public double divide(double a, double b) {
        countOperation++;
        return calculator.divide(a, b);
    }

    public double multiply(double a, double b) {
        countOperation++;
        return calculator.multiply(a, b);
    }

    public double power(double a, int b) {
        countOperation++;
        return calculator.power(a, b);
    }

    public double sum(double a) {
        countOperation++;
        return calculator.abs(a);
    }

    public double root(double a, int b) {
        countOperation++;
        return calculator.root(a, b);
    }

    public String getCoreTypeName() {
        return calculator.getClass().toString();
    }

    public int getCountOperation() {
        return countOperation;
    }
}