package tree;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode node = buildTree(inorder, postorder);
        System.out.println(node.toString());
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null ||
                inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int val = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(val);

        if (postorder.length == 1) {
            node.left = null;
            node.right = null;
            return node;
        }

        int divIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                divIndex = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, divIndex);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, divIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, divIndex + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, divIndex, postorder.length - 1);

        node.left = buildTree(leftInorder, leftPostorder);
        node.right = buildTree(rightInorder, rightPostorder);

        return node;
    }
}
