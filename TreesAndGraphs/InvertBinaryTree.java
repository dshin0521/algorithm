package TreesAndGraphs;

import pojo.TreeNode;
import utils.TreeUtil;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    private static void invertTreeHelper(TreeNode head) {
        if (head == null) return;
        TreeNode tempNode = head.left;
        head.left = head.right;
        head.right = tempNode;
        invertTreeHelper(head.left);
        invertTreeHelper(head.right);
    }

    public static void main(String[] args) {
        TreeNode testRoot = TreeUtil.makeBinaryTree(new Integer[]{4,2,7,1,3,6,9});
        invertTree(testRoot);
    }
}
