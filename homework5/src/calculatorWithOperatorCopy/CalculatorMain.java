package calculatorWithOperatorCopy;

import calculatorWithOperator.CalculatorWithOperator;

import java.text.DecimalFormat;

public class CalculatorMain {
    private static DecimalFormat df;

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");   //для форматированного вывода вещественных чисел (без незначащих вещественных нулей)

        System.out.println("Реализация CalculatorWithOperatorCopy:");
        CalculatorWithOperatorCopy calc = new CalculatorWithOperatorCopy();

        double a = 4.1;
        double b = calc.multiply(15, 7);
        double c = calc.divide(28, 5);
        c = calc.power(c, 2);
        double result = calc.sum(a, b);
        result = calc.sum(result, c);

        System.out.printf("4.1 + 15 * 7 + (28 / 5) ^ 2 = %s\n", df.format(result));
        System.out.printf("%s / 0 = %s\n", df.format(result),  df.format(result / 0));
        System.out.printf("%s / 0.0d = %s\n", df.format(result),  df.format(result / 0.0d));
    }
}