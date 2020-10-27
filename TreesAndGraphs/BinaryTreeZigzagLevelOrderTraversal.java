package TreesAndGraphs;

import pojo.TreeNode;
import utils.ListUtil;
import utils.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        zigzagLevelOrder(root, list, 0);
        return list;
    }

    private static void zigzagLevelOrder(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (list.size() <= level) list.add(new LinkedList<>());

        if (level % 2 == 0) {
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0, root.val);
        }

        level++;
        zigzagLevelOrder(root.left, list, level);
        zigzagLevelOrder(root.right, list, level);
    }

    public static void main(String[] args) {
        TreeNode testTree = TreeUtil.makeBinaryTree(new Integer[]{3,9,20,null,null,15,7});
        ListUtil.printList(zigzagLevelOrder(testTree));

        testTree = TreeUtil.makeBinaryTree(new Integer[]{1,2,3,4,null,null,5});
        ListUtil.printList(zigzagLevelOrder(testTree));

        testTree = TreeUtil.makeBinaryTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        ListUtil.printList(zigzagLevelOrder(testTree));
    }
}
