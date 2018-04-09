package Stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || minStack.peek() >= node) {
            minStack.push(node);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int node = stack.peek();
        stack.pop();
        if (minStack.peek() == node) {
            minStack.pop();
        }
    }

    public int min() {
        return minStack.peek();
    }
}
