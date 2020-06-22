package calculatorWithMemory;

import calculatorWithOperator.CalculatorWithOperator;
import calculatorWithOperatorCopy.CalculatorWithOperatorCopy;
import calculatorWithOperatorExtends.CalculatorWithOperatorExtends;

import java.text.DecimalFormat;

public class CalculatorMain {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");   //для форматированного вывода вещественных чисел (без незначащих вещественных нулей)

        System.out.println("Реализация CalculatorWithMemory:");
        System.out.println();

        //поочередное "обёртывание" всех классов, реализующих интерфейс CalcInterface
        System.out.println("Демонстрация \"Декоратора\"");
        CalculatorWithMemory calcWithMem = new CalculatorWithMemory(new CalculatorWithOperator());
        System.out.println("обёрнут " + calcWithMem.getCoreTypeName());
        calcWithMem = new CalculatorWithMemory(new CalculatorWithOperatorCopy());
        System.out.println("теперь обёрнут " + calcWithMem.getCoreTypeName());
        calcWithMem = new CalculatorWithMemory(new CalculatorWithOperatorExtends());
        System.out.println("теперь обёрнут " + calcWithMem.getCoreTypeName());
        System.out.println();

        //поочередное выполнение арифметических операций с занесением промежуточных результатов в память
        double tmp = calcWithMem.divide(28, 5);
        calcWithMem.memoryWrite(tmp);

        tmp = calcWithMem.power(calcWithMem.memoryRead(), 2);
        calcWithMem.memoryWrite(tmp);

        tmp = calcWithMem.multiply(15, 7);
        tmp += calcWithMem.memoryRead();
        calcWithMem.memoryWrite(tmp);

        tmp = calcWithMem.memoryRead();
        tmp += 4.1;

        System.out.printf("4.1 + 15 * 7 + (28 / 5) ^ 2 = %s\n", df.format(tmp));
        System.out.printf("%s / 0 = %s\n", df.format(tmp),  df.format(tmp / 0));
        System.out.printf("%s / 0.0d = %s\n", df.format(tmp),  df.format(tmp / 0.0d));
    }
}