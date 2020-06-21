package calculatorWithOperator;

public class CalculatorWithOperatorCopy {
    //вещественное сложение
    public static double sum(double a, double b) {
        return a + b;
    }

    //вещественное вычитание
    public static double subtract(double a, double b) {
        return a - b;
    }

    //вещественное деление
    public static double divide(double a, double b) {
        return a / b;
    }

    //вещественное умножение
    public static double multiply(double a, double b) {
        return a * b;
    }

    //возведение вещественного чистла в целочисленную степень
    public static double power(double a, int b) {
        return Math.pow(a, b);
    }

    //модуль вещественного числа
    public static double abs(double a) {
        return Math.abs(a);
    }

    //извлечение целочисленного корня из вещественного числа
    public static double root(double a, int b) {
        return Math.pow(a, 1.0 / b);
    }
}