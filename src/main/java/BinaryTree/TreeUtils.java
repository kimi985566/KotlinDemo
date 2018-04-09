package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
        //TODO:非递归
    }

}
