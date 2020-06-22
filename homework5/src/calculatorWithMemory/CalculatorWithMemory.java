package calculatorWithMemory;

import calculatorWithOperator.CalcInterface;

public class CalculatorWithMemory {
    private CalcInterface calculator;
    private double memory;

    public CalculatorWithMemory(CalcInterface calculator) {
        this.calculator = calculator;
        memory = 0;
    }

    public double sum(double a, double b) {
        return calculator.sum(a, b);
    }

    public double subtract(double a, double b) {
        return calculator.subtract(a, b);
    }

    public double divide(double a, double b) {
        return calculator.divide(a, b);
    }

    public double multiply(double a, double b) {
        return calculator.multiply(a, b);
    }

    public double power(double a, int b) {
        return calculator.power(a, b);
    }

    public double abs(double a) {
        return calculator.abs(a);
    }

    public double root(double a, int b) {
        return calculator.root(a, b);
    }

    public double memoryRead() {
        return memory;
    }

    public void memoryWrite(double value) {
        memory = value;
    }

    //информация о типе обернутого объекта
    public String getCoreTypeName() {
        return calculator.getClass().toString();
    }
}