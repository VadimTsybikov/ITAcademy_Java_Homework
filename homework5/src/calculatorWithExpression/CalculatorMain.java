package calculatorWithExpression;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorWithExpression calc = new CalculatorWithExpression();
        System.out.println(calc.evaluate("6*(3+2)+2^(2-1)+1/5+|5-7|-pi+e"));
    }
}