package TreesAndGraphs;


import pojo.TreeNode;
import utils.TreeUtil;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, Math.min(min, root.val), root.val) && isValidBST(root.right, root.val, Math.max(max, root.val));
    }

    public static void main(String[] args) {
        TreeNode testTree = TreeUtil.makeBinaryTree(new Integer[]{2,1,3});
        System.out.println(isValidBST(testTree));

        testTree = TreeUtil.makeBinaryTree(new Integer[]{5,1,4,null,null,3,6});
        System.out.println(isValidBST(testTree));

        testTree = TreeUtil.makeBinaryTree(new Integer[]{3,null,30,10,null,null,15,null,45});
        System.out.println(isValidBST(testTree));
    }
}