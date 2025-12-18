
import java.util.*;

class MyStack {
    Queue<Integer> input;

    public MyStack() {
        input = new LinkedList<>();

    }

    public void push(int x) {
        input.add(x);
        for (int i = 0; i < input.size() - 1; i++) {
            input.add(input.poll());
        }

    }

    public int pop() {
        return input.poll();

    }

    public int top() {
        return input.peek();

    }

    public boolean empty() {

        return input.isEmpty();
    }
}