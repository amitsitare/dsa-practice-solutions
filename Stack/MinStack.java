
import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
        mainStack = new Stack<>();

    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

    }

    public void pop() {
        int removeE = mainStack.pop();
        if (removeE == minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {
        return mainStack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }
}