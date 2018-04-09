package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class TreeUtils {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    //入队从左到右，出队也是从左到右
    public static void levelTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayBlockingQueue<>(10000);
        TreeNode last = root;//当前行的最右节点
        TreeNode nLast = root;//下一行的最右节点
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode out = queue.poll();
            System.out.print(out.data + " ");
            list.add(out.data);
            if (out.left != null) {
                queue.add(out.left);
                nLast = out.left;
            }
            if (out.right != null) {
                queue.add(out.right);
                nLast = out.right;
            }
            if (out == last) {
                System.out.print("");
                last = nLast;
            }
        }
        return list;
    }

    /**
     * 前序遍历
     */

    public static void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.data + " ");

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.data + " ");
        inorderTraversalRec(root.right);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        if (cur != null) {
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.print(cur.data + " ");
                    cur = cur.right;
                }
            }
        }
    }

    public static void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.data + " ");
    }

    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            output.push(cur);

            if (cur.left != null) {
                output.push(cur.left);
            }

            if (cur.right != null) {
                output.push(cur.right);
            }
        }

        while (!output.isEmpty()) {
            System.out.print(output.pop().data + " ");
        }
    }

}
