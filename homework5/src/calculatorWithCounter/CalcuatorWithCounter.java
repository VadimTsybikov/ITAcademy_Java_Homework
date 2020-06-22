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

    //вещественное сложение
    public double sum(double a, double b) {
        countOperation++;
        return calculator.sum(a, b);
    }

    //вещественное вычитание
    public double subtract(double a, double b) {
        countOperation++;
        return calculator.subtract(a, b);
    }

    //вещественное деление
    public double divide(double a, double b) {
        countOperation++;
        return calculator.divide(a, b);
    }

    //вещественное умножение
    public double multiply(double a, double b) {
        countOperation++;
        return calculator.multiply(a, b);
    }

    //возведение вещественного числа в целочисленную степень
    public double power(double a, int b) {
        countOperation++;
        return calculator.power(a, b);
    }

    //модуль вещественного числа
    public double abs(double a) {
        countOperation++;
        return calculator.abs(a);
    }

    //извлечение целочисленного корня из вещественного числа
    public double root(double a, int b) {
        countOperation++;
        return calculator.root(a, b);
    }

    //информация о типе обернутого объекта
    public String getCoreTypeName() {
        return calculator.getClass().toString();
    }

    //количество выполненных операций
    public int getCountOperation() {
        return countOperation;
    }
}