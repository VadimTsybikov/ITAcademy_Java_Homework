package calculatorWithExpression;

import calculatorWithExpression.core.OperationsBinaryTree;
import calculatorWithExpression.core.SimpleOperation;
import calculatorWithExpression.core.Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorWithExpression {
    private static final double PI = 3.1416;
    private static final double E = 2.7183;
    private static final String operators = "*/+-^";
    private static final String numeric = "0123456789-.";
    private static final String literals = "PIE";

    private Stack parenthesesStack;
    private int lastCharPos;

    {
        parenthesesStack = new Stack();
        lastCharPos = 0;
    }

    public double evaluate(String expr) {
        while (expr.contains(" "))
            expr = expr.replace(' ', '\0');

        Matcher numberMatcher = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+").matcher(expr);
        if (numberMatcher.matches())
            return Double.valueOf(expr);

        OperationsBinaryTree operationsTree = new OperationsBinaryTree();

        Boolean seekForNumber = false;
        Boolean seekForLiteral = false;
        Boolean seekForAbs = false;
        for (int i = 0; i < expr.length(); i++) {
            char curChar = expr.charAt(i);

            if (i == expr.length() - 1) {
                Double value = Double.NaN;
                if (numeric.indexOf(curChar) > -1) {
                    value = Double.valueOf(expr.substring(lastCharPos));
                } else if (literals.indexOf(Character.toUpperCase(curChar)) > -1) {
                    String valueStr = expr.substring(lastCharPos);
                    if (!valueStr.isEmpty()) {
                        value = parseLiteral(valueStr);
                    }
                }
                if (value != Double.NaN) {
                    operationsTree.assignOperand(value);
                }
            }
            else if (operators.indexOf(curChar) > -1) {
                if ((!seekForAbs) && (parenthesesStack.getHead() == null)) {
                    if (seekForNumber) {
                        seekForNumber = false;

                        String valueStr = expr.substring(lastCharPos, i);
                        if (!valueStr.isEmpty()) {
                            double value = Double.valueOf(valueStr);
                            operationsTree.assignOperand(new SimpleOperation(value));
                            lastCharPos = i + 1;
                        }
                    } else if (seekForLiteral) {
                        seekForLiteral = false;

                        String literalStr = expr.substring(lastCharPos, i);
                        if (!literalStr.isEmpty()) {
                            operationsTree.assignOperand(new SimpleOperation(parseLiteral(literalStr)));
                            lastCharPos = i + 1;
                        }
                    }
                    operationsTree.setOperation(curChar);
                }
            } else if (numeric.indexOf(curChar) > -1) {
                if ((!seekForNumber) && (!seekForLiteral) && (!seekForAbs) && (parenthesesStack.getHead() == null)) {
                    seekForNumber = true;
                    lastCharPos = i;
                }
            } else if (literals.indexOf(Character.toUpperCase(curChar)) > -1) {
                if ((!seekForLiteral) && (!seekForAbs) && (parenthesesStack.getHead() == null)) {
                    seekForLiteral = true;
                    lastCharPos = i;
                }
            } else if (curChar == '(') {
                if ((!seekForLiteral) && (!seekForAbs)) {
                    parenthesesStack.Push("(");
                    lastCharPos = i + 1;
                }
            } else if (curChar == ')') {
                if ((!seekForLiteral) && (!seekForAbs) && (parenthesesStack.Pop() == "(") && (parenthesesStack.getHead() == null)) {
                    String subexpr = expr.substring(lastCharPos, i);
                    if (!subexpr.isEmpty()) {
                        Double subExprValue = evaluate(subexpr);
                        operationsTree.assignOperand(new SimpleOperation(subExprValue));
                        lastCharPos = i + 1;
                    } else {
                        throw new IllegalArgumentException("Неверное выражение в скобках");
                    }
                } else
                    throw new IllegalArgumentException("Некорректный порядок скобок в выражении");
            } else if (curChar == '|') {
                if (!seekForLiteral) {
                    if (!seekForAbs) {
                        seekForAbs = true;
                        lastCharPos = i + 1;
                    } else {
                        seekForAbs = false;
                        String subexpr = expr.substring(lastCharPos, i);
                        if (!subexpr.isEmpty()) {
                            Double subExprValue = evaluate(subexpr);
                            subExprValue *= (subExprValue < 0 ? -1 : 1);
                            operationsTree.assignOperand(new SimpleOperation(subExprValue));
                            lastCharPos = i + 1;
                        } else {
                            throw new IllegalArgumentException("Неверное выражение в скобках");
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Неверное выражение");
            }
        }

        return operationsTree.getResult();
    }

    private Double parseLiteral(String literal) {
        if (!literal.isEmpty()) {
            switch (literal.toUpperCase()) {
                case "PI":
                    return PI;
                case "E":
                    return E;
                default:
                    throw new IllegalArgumentException("Неверное выражение");
            }
        }
        return Double.NaN;
    }
}