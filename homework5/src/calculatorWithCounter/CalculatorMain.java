package calculatorWithCounter;

import calculatorWithOperator.CalculatorWithOperator;
import calculatorWithOperatorCopy.CalculatorWithOperatorCopy;
import calculatorWithOperatorExtends.CalculatorWithOperatorExtends;

import java.text.DecimalFormat;

public class CalculatorMain {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");   //для форматированного вывода вещественных чисел (без незначащих вещественных нулей)

        System.out.println("Реализация CalculatorWithCounter:");
        System.out.println();

        //поочередное "обёртывание" всех классов, реализующих интерфейс ICalculator
        System.out.println("Демонстрация \"Декоратора\"");
        CalcuatorWithCounter calcWithCounter = new CalcuatorWithCounter(new CalculatorWithOperator());
        System.out.println("обёрнут " + calcWithCounter.getCoreTypeName());
        calcWithCounter = new CalcuatorWithCounter(new CalculatorWithOperatorCopy());
        System.out.println("теперь обёрнут " + calcWithCounter.getCoreTypeName());
        calcWithCounter = new CalcuatorWithCounter(new CalculatorWithOperatorExtends());
        System.out.println("теперь обёрнут " + calcWithCounter.getCoreTypeName());
        System.out.println();

        //вычисление выражения
        double a = 4.1;
        double b = calcWithCounter.multiply(15, 7);
        double c = calcWithCounter.divide(28, 5);
        c = calcWithCounter.power(c, 2);
        double result = calcWithCounter.sum(a, b);
        result = calcWithCounter.sum(result, c);

        //вывод результата
        System.out.printf("4.1 + 15 * 7 + (28 / 5) ^ 2 = %s\n", df.format(result));
        System.out.printf("%s / 0 = %s\n", df.format(result),  df.format(result / 0));
        System.out.printf("%s / 0.0d = %s\n", df.format(result),  df.format(result / 0.0d));

        System.out.println("Количество выполненных операция: " + calcWithCounter.getCountOperation());
    }
}