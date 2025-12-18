class ArrayStack {
    private int[] stack;
    private int top;

    public ArrayStack() {
        stack = new int[100];
        top = -1;
    }

    public void push(int x) {
        stack[++top] = x;
    }

    public int pop() {
        return stack[top--];
    }

    public int top() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.isEmpty());

        s.pop();
        s.pop();
        System.out.println(s.isEmpty());
    }
}
