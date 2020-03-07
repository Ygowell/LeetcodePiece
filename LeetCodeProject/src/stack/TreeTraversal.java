package stack;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class TreeTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return results;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
                TreeNode temp = node.right;
                while (temp.left != null) {
                    stack.push(temp.left);
                    temp = temp.left;
                }
            }
        }

        return results;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(0, node.val);
            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }

        return results;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int outCount = 1;
        int inCount;
        while (!queue.isEmpty()) {
            inCount = 0;
            List<Integer> levels = new ArrayList<>();

            while (outCount > 0) {
                TreeNode first = queue.poll();
                outCount--;
                levels.add(first.val);

                if (first.left != null) {
                    queue.offer(first.left);
                    inCount++;
                }
                if (first.right != null) {
                    queue.offer(first.right);
                    inCount++;
                }
            }

            results.add(levels);
            outCount = inCount;
        }

        return results;
    }

    public static void main(String[] args) {

    }
}
