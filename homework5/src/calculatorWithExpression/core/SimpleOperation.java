package calculatorWithExpression.core;

public class SimpleOperation {
    private Operation operator;
    private SimpleOperation operand1;
    private SimpleOperation operand2;
    private double result;

    public SimpleOperation() {
        this(Double.NaN);
    }

    public SimpleOperation(double value) {
        operator = Operation.NONE;
        operand1 = null;
        operand2 = null;
        result = value;
    }

    public boolean isFull() {
        return operand1 != null && operand2 != null;
    }

    public boolean isEmpty() {
        return operand1 == null && operand2 == null;
    }

    public SimpleOperation setOperation(char operationSign) {
        if (!isOperationSet()) {
            switch (operationSign) {
                case '+':
                    operator = Operation.SUM;
                    break;
                case '-':
                    operator = Operation.SUBTRACT;
                    break;
                case '/':
                    operator = Operation.DIVIDE;
                    break;
                case '*':
                    operator = Operation.MULTIPLY;
                    break;
                case '^':
                    operator = Operation.POWER;
                    break;
                default:
                    operator = Operation.NONE;
                    break;
            }
            return this;
        }
        else {
            if (operand2 != null) {
                if (operand2.isEmpty() && operand2.result != Double.NaN) {
                    operand2.operand1 = new SimpleOperation(operand2.result);
                    operand2.operand2 = null;
                    operand2.setOperation(operationSign);
                    operand2.result = Double.NaN;
                    return operand2;
                }
                else if (!operand2.isEmpty()) {
                    operand2.setOperation(operationSign);
                    return this;
                }
                else {
                    throw new IllegalArgumentException("Неверный порядок операторов");
                }
            }
            else {
                throw new IllegalArgumentException("Неверный порядок операторов");
            }
        }
    }

    public boolean isOperationSet() {
        return operator != Operation.NONE;
    }

    public SimpleOperation assignOperand(SimpleOperation operationAsOperand) {
        if (operand1 == null) {
            if (Double.compare(result, Double.NaN) == 0) {
                operand1 = operationAsOperand;
            } else {
                operand1 = new SimpleOperation(result);
                operand2 = operationAsOperand;
                result = Double.NaN;
            }
            return this;
        }
        else if (operand2 == null) {
            operand2 = operationAsOperand;
            return this;
        }
        else {
            operand2 = new SimpleOperation();
            operand2.assignOperand(operationAsOperand);
            return operand2;
        }
    }

    public double getResult() {
        if ((operand1 != null) && (operand2 != null) && (operator != Operation.NONE)) {
            switch (operator) {
                case SUM:
                    result = operand1.getResult() + operand2.getResult();
                    break;
                case SUBTRACT:
                    result = operand1.getResult() - operand2.getResult();
                    break;
                case DIVIDE:
                    result = operand1.getResult() / operand2.getResult();
                    break;
                case MULTIPLY:
                    result = operand1.getResult() * operand2.getResult();
                    break;
                case POWER:
                    double n = operand1.getResult();
                    double pow = operand2.getResult();
                    result = 1;
                    for (int i = 1; i <= pow; i++)
                        result *= n;
                    break;
            }
            return result;
        }
        else {
            if (result != Double.NaN)
                return result;
            else
                throw new IllegalArgumentException("Некорректное выражение");
        }
    }

    public void setResult(double result) {
        this.result = result;
    }
}