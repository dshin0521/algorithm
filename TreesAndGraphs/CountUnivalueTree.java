package TreesAndGraphs;

import utils.TreeUtil;
import pojo.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example :
 *
 * Input:  root = [5,1,5,5,5,null,5]
 *
 *      5
 *     / \
 *    1   5
 *   / \   \
 *  5   5   5
 *
 * Output: 4
 */
public class CountUnivalueTree {

    private static int count = 0;

    public static int countUnivalSubtrees(TreeNode root) {
        countUnivalSubTreesHelper(root);
        return count;
    }

    private static boolean countUnivalSubTreesHelper(TreeNode node) {
        if (node == null) return true;
        boolean left = countUnivalSubTreesHelper(node.left);
        boolean right = countUnivalSubTreesHelper(node.right);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) return false;
            if (node.right != null && node.val != node.right.val) return false;
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode head = TreeUtil.makeBinaryTree(new Integer[]{5,1,5,5,5,null,5});
        System.out.println(countUnivalSubtrees(head));
    }
}
