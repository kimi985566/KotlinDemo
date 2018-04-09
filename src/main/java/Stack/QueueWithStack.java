package Stack;

import java.util.Stack;

public class QueueWithStack {

    private static Stack<Object> stack1 = new Stack<>();
    private static Stack<Object> stack2 = new Stack<>();

    public static void appendTail(Object item) {
        stack1.push(item);
        System.out.println("压入栈元素：" + item);
    }

    public static void deleteHead() {
        if (!stack2.empty()) {
            System.out.println("弹出元素为：" + stack2.pop());
        } else {
            if (stack1.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            while (!stack1.isEmpty()) {
                Object item = stack1.pop();
                stack2.push(item);
            }
        }
    }
}
