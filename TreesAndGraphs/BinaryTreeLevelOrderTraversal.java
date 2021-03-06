package TreesAndGraphs;

import pojo.TreeNode;
import utils.ListUtil;
import utils.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private static void levelOrder(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (list.size() <= level) {
            list.add(new LinkedList<>());
        }
        list.get(level).add(root.val);

        level++;
        levelOrder(root.left, list, level);
        levelOrder(root.right, list, level);
    }

    public static List<List<Integer>> levelOrderIterative(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> level = new ArrayList<>(queueSize);
            for (int i = 0; i < queueSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levels.add(level);
        }

        return levels;
    }

    public static void main(String[] args) {
        TreeNode testTree = TreeUtil.makeBinaryTree(new Integer[]{3,9,20,null,null,15,7});
        ListUtil.printList(levelOrder(testTree));
        ListUtil.printList(levelOrderIterative(testTree));
    }
}
