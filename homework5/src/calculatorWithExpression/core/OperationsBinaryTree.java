package calculatorWithExpression.core;

public class OperationsBinaryTree {
    private SimpleOperation root;
    private SimpleOperation activeItem;

    public OperationsBinaryTree() {
        root = new SimpleOperation();
        activeItem = root;
    }

    public void setOperation(char operationSign) {
        if (operationSign == '^' || operationSign == '*' || operationSign == '/') {
            activeItem = activeItem.setOperation(operationSign);
        } else {
            if (activeItem.isFull()) {
                SimpleOperation newRoot = new SimpleOperation();
                newRoot.assignOperand(root);
                newRoot.setOperation(operationSign);
                root = newRoot;
                activeItem = root;
            } else {
                activeItem = activeItem.setOperation(operationSign);
            }
        }
    }

    public void assignOperand(SimpleOperation operationAsOperand) {
        activeItem.assignOperand(operationAsOperand);
    }

    public void assignOperand(Double value) {
        if (activeItem.isEmpty()) {
            activeItem.setResult(value);
        } else {
            activeItem.assignOperand(new SimpleOperation(value));
        }
    }

    public double getResult() {
        return root.getResult();
    }
}