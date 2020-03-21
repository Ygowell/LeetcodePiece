package tree;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 *     3
 *    / \
 *   9  20
 *  /    \
 * 15     7
 */
public class BuildTreeByPreInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0
                || inorder.length == 0) {
            return null;
        }

        int val = preorder[0];
        TreeNode node = new TreeNode(val);
        if (preorder.length == 1) {
            node.left = null;
            node.right = null;
            return node;
        }

        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }

        int leftPreOrder[] = Arrays.copyOfRange(preorder, 1, 1 + index);
        int leftInOrder[] = Arrays.copyOfRange(inorder, 0, index);
        int rightPreOrder[] = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
        int rightInOrder[] = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        node.left = buildTree(leftPreOrder, leftInOrder);
        node.right = buildTree(rightPreOrder, rightInOrder);
        return node;
    }
}
