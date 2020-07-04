package calculatorWithExpression.core;

public class Stack {
    private StackItem head;

    public Stack() {
        head = null;
    }

    public void Push(String value) {
        StackItem newHead = new StackItem(value);
        newHead.setNextItem(head);
        head = newHead;
    }

    public Object Pop() {
        if (head != null) {
            Object headValue = head.getValue();
            head = head.getNextItem();
            return headValue;
        }
        else
            return null;
    }

    public StackItem getHead() {
        return head;
    }
}