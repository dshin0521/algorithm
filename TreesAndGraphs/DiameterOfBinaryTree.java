package TreesAndGraphs;

import pojo.TreeNode;
import utils.TreeUtil;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
  static int maxDepth = 0;

  public static int diameterOfBinaryTree(TreeNode root) {
    getDeepestDepth(root);
    return maxDepth;
  }

  private static int getDeepestDepth(TreeNode root) {
    if (root == null) return 0;

    int leftDepth = getDeepestDepth(root.left);
    int rightDepth = getDeepestDepth(root.right);

    maxDepth = Math.max(maxDepth, leftDepth + rightDepth);
    return Math.max(leftDepth, rightDepth) + 1;
  }

  public static void main(String[] args) {
    TreeNode testTree = TreeUtil.makeBinaryTree(new Integer[]{1,2,3,4,5,null,null});
    System.out.println(diameterOfBinaryTree(testTree));
  }
}
