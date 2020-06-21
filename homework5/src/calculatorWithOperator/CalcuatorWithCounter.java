package calculatorWithOperator;

public class CalcuatorWithCounter {
    private CalculatorWithOperator calculator;
    private int countOperation;

    public CalcuatorWithCounter(CalculatorWithOperator calculator) {
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

    public int getCountOperation() {
        return countOperation;
    }
}