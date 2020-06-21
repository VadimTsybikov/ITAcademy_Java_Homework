package calculatorWithOperator;

import java.text.DecimalFormat;

public class CalculatorMain {
    private static DecimalFormat df;        //для форматированного вывода вещественных чисел (без незначащих вещественных нулей)

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.#");

        System.out.println("Реализация CalculatorWithOperator:");

        double a1 = 4.1;
        double b1 = CalculatorWithOperator.multiply(15, 7);
        double c1 = CalculatorWithOperator.divide(28, 5);
        c1 = CalculatorWithOperator.power(c1, 2);
        double result1 = CalculatorWithOperator.sum(a1, b1);
        result1 = CalculatorWithOperator.sum(result1, c1);

        System.out.printf("4.1 + 15 * 7 + (28 / 5) ^ 2 = %s\n", df.format(result1));
        System.out.printf("%s / 0 = %s\n", df.format(result1),  df.format(result1 / 0));
        System.out.printf("%s / 0.0d = %s\n", df.format(result1),  df.format(result1 / 0.0d));

        System.out.println();

        System.out.println("Реализация CalculatorWithOperatorCopy:");

        double a2 = 4.1;
        double b2 = CalculatorWithOperator.multiply(15, 7);
        double c2 = CalculatorWithOperator.divide(28, 5);
        c2 = CalculatorWithOperator.power(c2, 2);
        double result2 = CalculatorWithOperator.sum(a2, b2);
        result2 = CalculatorWithOperator.sum(result2, c2);

        System.out.printf("4.1 + 15 * 7 + (28 / 5) ^ 2 = %s\n", df.format(result2));
        System.out.printf("%s / 0 = %s\n", df.format(result2),  df.format(result2 / 0));
        System.out.printf("%s / 0.0d = %s\n", df.format(result2),  df.format(result2 / 0.0d));

        System.out.println();

        System.out.println("Реализация CalculatorWithOperatorExtends:");

        double a3 = 4.1;
        double b3 = CalculatorWithOperator.multiply(15, 7);
        double c3 = CalculatorWithOperator.divide(28, 5);
        c3 = CalculatorWithOperator.power(c3, 2);
        double result3 = CalculatorWithOperator.sum(a3, b3);
        result3 = CalculatorWithOperator.sum(result3, c3);

        System.out.printf("4.1 + 15 * 7 + (28 / 5) ^ 2 = %s\n", df.format(result3));
        System.out.printf("%s / 0 = %s\n", df.format(result3),  df.format(result3 / 0));
        System.out.printf("%s / 0.0d = %s\n", df.format(result3),  df.format(result3 / 0.0d));

        System.out.println();
    }
}