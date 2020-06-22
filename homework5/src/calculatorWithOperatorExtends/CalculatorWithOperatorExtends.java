package calculatorWithOperatorExtends;

import calculatorWithOperator.CalcInterface;
import calculatorWithOperator.CalculatorWithOperator;

public class CalculatorWithOperatorExtends extends CalculatorWithOperator implements CalcInterface {
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