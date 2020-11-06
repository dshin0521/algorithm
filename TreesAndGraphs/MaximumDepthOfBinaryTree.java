package TreesAndGraphs;

import pojo.TreeNode;
import utils.TreeUtil;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }

    private static int maxDepthHelper(TreeNode root, int level) {
        if (root == null) return level;
        level++;
        return Math.max(maxDepthHelper(root.left, level), maxDepthHelper(root.right, level));
    }

    public static void main(String[] args) {
        TreeNode testTree = TreeUtil.makeBinaryTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(maxDepth(testTree));
    }
}
