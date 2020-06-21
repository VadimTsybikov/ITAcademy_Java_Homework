package calculatorWithOperator;

public class CalculatorWithOperatorExtends extends CalculatorWithOperator {
    //возведение вещественного числа в целочисленную степень
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