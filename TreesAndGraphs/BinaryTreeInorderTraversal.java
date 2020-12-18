package TreesAndGraphs;

import pojo.TreeNode;
import utils.ListUtil;
import utils.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [2,1]
 *
 * Example 5:
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversalRecursive(root, list);
        return list;
    }

    private static void inorderTraversalRecursive(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversalRecursive(root.left, list);
        list.add(root.val);
        inorderTraversalRecursive(root.right, list);
    }

    private static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur !=null || !stack.isEmpty()){
            while (cur!=null) {
                stack.add(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.makeBinaryTree(new Integer[]{1, null, 2, null, null, 3});
        ListUtil.printList(inorderTraversalRecursive(root));
        ListUtil.printList(inorderTraversalIterative(root));
    }
}
