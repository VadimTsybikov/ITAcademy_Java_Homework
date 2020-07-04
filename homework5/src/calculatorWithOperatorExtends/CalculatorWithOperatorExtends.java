package calculatorWithOperatorExtends;

import calculatorWithOperator.CalculatorWithOperator;
import calculatorWithOperator.ICalculator;

public class CalculatorWithOperatorExtends extends CalculatorWithOperator implements ICalculator {
    //переопределение метода базового класса соответствующим функационалом библиотеки Math
    public double power(double a, int b) {
        return Math.pow(a, b);
    }

    //переопределение метода базового класса соответствующим функационалом библиотеки Math
    public double abs(double a) {
        return Math.abs(a);
    }

    //переопределение метода базового класса соответствующим функационалом библиотеки Math
    public double root(double a, int b) {
        return Math.pow(a, 1.0 / b);
    }
}