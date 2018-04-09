package linkedlist;

import java.util.HashSet;
import java.util.Stack;

public class StackUtils {

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //删除单链表中的指定节点
    public static void deleteNode(Node head, Node node) {
        //删除尾节点，采用顺序查找，找到尾节点的前一节点
        if (node.next == null) {
            while (head.next != null) {
                head = head.next;
            }
            head.next = null;
            //删除头结点
        } else if (head == node) {
            head = null;
            //删除任意节点
        } else {
            Node q = head.next;
            node.data = q.data;
            node.next = q.next;
        }
    }

    //删除单链表中的指定的值：利用栈
    public Node removeDataWithStack(Node head, int num) {
        Stack<Node> stack = new Stack<Node>();
        while (head != null) {
            if (head.data != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    //删除指定节点，不利用栈
    public Node removeDataByNode(Node head, int num) {
        while (head != null) {
            if (head.data != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.data == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public void deleteDuplication(Node head) {
        //如果为空，则直接返回
        if (head == null) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head;
        set.add(head.data);
        while (cur != null) {
            if (set.contains(cur.data)) {
                pre.next = cur.next;
            } else {
                set.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public Node addList2(Node head1, Node head2) {

        int n1 = 0;//链表1数值
        int n2 = 0;//链表2数值
        int n = 0; //n1+n2+ca
        int ca = 0;//进位

        Node node = null;
        Node pnode = null;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (head1 != null) {
            stack1.push(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.data);
            head2 = head2.next;
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            node = new Node(n % 10);
            node.next = pnode;
            pnode = node;
            ca = n / 10;
        }

        if (ca == 1) {
            pnode = node;
            node = new Node(n / 10);
            node.next = pnode;
        }

        return node;
    }

    //判断是否为回文结构
    public boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head.next != null) {
            if (head.data != stack.pop().data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static Node deleteLastKthNode(Node head, int k) {
        if (k <= 0) {
            return head;
        }
        if (head == null) {
            return head;
        }

        Node p = head;
        for (int i = 0; i < k; i++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return head;
            }
        }

        Node q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
