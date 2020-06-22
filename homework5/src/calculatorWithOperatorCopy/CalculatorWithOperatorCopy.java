package calculatorWithOperatorCopy;

import calculatorWithOperator.CalcInterface;

public class CalculatorWithOperatorCopy implements CalcInterface {
    //вещественное сложение
    public double sum(double a, double b) {
        return a + b;
    }

    //вещественное вычитание
    public double subtract(double a, double b) {
        return a - b;
    }

    //вещественное деление
    public double divide(double a, double b) {
        return a / b;
    }

    //вещественное умножение
    public double multiply(double a, double b) {
        return a * b;
    }

    //возведение вещественного числа в целочисленную степень
    public double power(double a, int b) {
        return Math.pow(a, b);
    }

    //модуль вещественного числа
    public double abs(double a) {
        return Math.abs(a);
    }

    //извлечение целочисленного корня из вещественного числа
    public double root(double a, int b) {
        return Math.pow(a, 1.0 / b);
    }
}