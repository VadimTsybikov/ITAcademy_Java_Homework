package calculatorWithExpression.core;

public class StackItem {
    private String value;
    private StackItem nextItem;

    public StackItem(String value) {
        this.value = value;
        nextItem = null;
    }

    public String getValue() {
        return value;
    }

    public void setNextItem(StackItem nextItem) {
        this.nextItem = nextItem;
    }

    public StackItem getNextItem() {
        return nextItem;
    }
}