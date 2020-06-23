package calculatorStringExpression;

public class CalculatorStringExpression {
    private static final double PI = 3.1415926535897932384626433832795;
    private static final double E = 2.7182818284590452353602874713527;
    private static final String operators = "+-/*^";
    private static final String numeric = "0123456789-.";

    public static double evaluate(String expr) {
        int lastCharPos = 0;
        while (expr.contains(" "))
            expr = expr.replace(' ', '\0');

        SimpleOperation operationsRoot = new SimpleOperation();

        boolean seekForNumber = false;
        boolean seekForParentheses = false;
        for (int i = 0; i < expr.length(); i++) {
            char curChar = expr.charAt(i);
            if (numeric.indexOf(curChar) > -1) {
                lastCharPos = i;
                seekForNumber = true;
            }
            if ((operators.indexOf(curChar) > -1) || (i == expr.length() - 1)) {
                if ((seekForNumber) || (i == expr.length() - 1)) {
                    seekForNumber = false;
                    String literal = expr.substring(lastCharPos, i);
                    double value = Double.valueOf(literal);
                    lastCharPos = i + 1;
                    if (operationsRoot == null) {
                        operationsRoot.assignOperand(new SimpleOperation(value));
                    }
                    else {
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
            }
            else if (curChar == '(') {
                seekForParentheses = true;
                lastCharPos = i + 1;
            }
            else if (seekForParentheses) {
                if (curChar == ')') {
                    seekForParentheses = false;
                    Double subExprValue = evaluate(expr.substring(lastCharPos, i - 1));
                    operationsRoot.assignOperand(new SimpleOperation(subExprValue));
                    lastCharPos = i + 1;
                }
            }
        }

        return operationsRoot.getResult();
    }
}