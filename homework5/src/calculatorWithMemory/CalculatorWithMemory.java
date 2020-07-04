package calculatorWithMemory;

import calculatorWithOperator.ICalculator;

public class CalculatorWithMemory {
    private ICalculator calculator;
    private double memory;

    public CalculatorWithMemory(ICalculator calculator) {
        this.calculator = calculator;
        memory = 0;
    }

    public final double sum(double a, double b) {
        return calculator.sum(a, b);
    }

    public final double subtract(double a, double b) {
        return calculator.subtract(a, b);
    }

    public final double divide(double a, double b) {
        return calculator.divide(a, b);
    }

    public final double multiply(double a, double b) {
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

    public final double memoryRead() {
        return memory;
    }

    public final void memoryWrite(double value) {
        memory = value;
    }

    //информация о типе обернутого объекта
    public final String getCoreTypeName() {
        return calculator.getClass().toString();
    }
}