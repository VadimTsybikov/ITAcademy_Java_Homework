package calculatorWithExpression;

import calculatorWithExpression.core.SimpleOperation;
import calculatorWithExpression.core.Stack;

public class CalculatorWithExpression {
    private static final double PI = 3.1415926535897932384626433832795;
    private static final double E = 2.7182818284590452353602874713527;
    private static final String operators = "*/+-^";
    private static final String numeric = "0123456789-.";

    private Stack parenthesesStack;
    private int lastCharPos;

    {
        parenthesesStack = new Stack();
        lastCharPos = 0;
    }

    public double evaluate(String expr) {
        while (expr.contains(" "))
            expr = expr.replace(' ', '\0');

        SimpleOperation operationsRoot = new SimpleOperation();

        boolean seekForNumber = false;
        for (int i = 0; i < expr.length(); i++) {
            char curChar = expr.charAt(i);
            if ((operators.indexOf(curChar) > -1) || (i == expr.length() - 1)) {
                if ((seekForNumber) || (i == expr.length() - 1)) {
                    seekForNumber = false;
                    String literal = expr.substring(lastCharPos, i);
                    double value = Double.valueOf(literal);
                    lastCharPos = i + 1;
                    if (operationsRoot == null) {
                        operationsRoot.assignOperand(new SimpleOperation(value));
                    } else {
                        if (operationsRoot.isCompleted()) {
                            if (curChar == '*' || curChar == '/')
                                operationsRoot.assignOperand(new SimpleOperation(value));
                            else {
                                SimpleOperation newRoot = new SimpleOperation();
                                newRoot.assignOperand(operationsRoot);
                                newRoot.assignOperand(new SimpleOperation(value));
                                operationsRoot = newRoot;
                            }
                        } else
                            operationsRoot.assignOperand(new SimpleOperation(value));
                    }
                }
                if (operators.indexOf(curChar) > -1)
                    operationsRoot.setOperation(curChar);
            } else if (numeric.indexOf(curChar) > -1) {
                if (!seekForNumber) {
                    lastCharPos = i;
                    seekForNumber = true;
                }
            } else  if (curChar == '(') {
                parenthesesStack.Push("(");
                lastCharPos = i + 1;
            } else if (curChar == ')') {
                if (parenthesesStack.Pop() == "(") {
                    Double subExprValue = evaluate(expr.substring(lastCharPos, i - 1));
                    operationsRoot.assignOperand(new SimpleOperation(subExprValue));
                    lastCharPos = i + 1;
                }
                else
                    throw new IllegalArgumentException("Некорректный порядок скобок в выражении");
            }
        }

        return operationsRoot.getResult();
    }
}