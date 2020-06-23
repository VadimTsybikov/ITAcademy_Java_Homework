package calculatorStringExpression;

public class SimpleOperation {
    private Operation operator;
    private SimpleOperation operand1;
    private SimpleOperation operand2;
    private double result;

    public SimpleOperation() {
        operator = Operation.NONE;
        operand1 = null;
        operand2 = null;
        result = Double.NaN;
    }

    public SimpleOperation(double value) {
        operator = Operation.NONE;
        operand1 = null;
        operand2 = null;
        result = value;
    }

    public boolean isCompleted() {
        return operand1 != null && operand2 != null;
    }

    public boolean setOperation(char operationSign) {
        switch (operationSign) {
            case '+':
                operator = Operation.SUM;
                return true;
            case '-':
                operator = Operation.SUBTRACT;
                return true;
            case '/':
                operator = Operation.DIVIDE;
                return true;
            case '*':
                operator = Operation.MULTIPLY;
                return true;
            case '^':
                operator = Operation.POWER;
                return true;
            case '|':
                operator = Operation.ABS;
                return true;
            default:
                operator = Operation.NONE;
                return false;
        }
    }

    public void assignOperand(SimpleOperation operationAsOperand) {
        if (operand1 == null)
            operand1 = operationAsOperand;
        else if (operand2 == null)
            operand2 = operationAsOperand;
        else {
            operand2 = new SimpleOperation();
            operand2.assignOperand(operationAsOperand);
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
                case ABS:
                    result = operand1.getResult();
                    result = result < 0 ? result * -1 : result;
                    break;
            }
        }
        return result;
    }
}