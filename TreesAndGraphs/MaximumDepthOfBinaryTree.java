package TreesAndGraphs;

import pojo.TreeNode;
import utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * Different approach using DFS
     */
    public static int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;

        Stack<NodeAndDepth> stack = new Stack<>();
        stack.push(new NodeAndDepth(root, 1));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            NodeAndDepth curr = stack.pop();
            TreeNode currNode = curr.node;
            if (maxDepth < curr.depth) maxDepth = curr.depth;
            if (currNode.right != null) stack.push(new NodeAndDepth(currNode.right, curr.depth + 1));
            if (currNode.left != null) stack.push(new NodeAndDepth(currNode.left, curr.depth + 1));
        }
        return maxDepth;
    }

    /**
     * Different approach using BFS
     */
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<NodeAndDepth> queue = new LinkedList<>();
        queue.offer(new NodeAndDepth(root, 1));
        int maxDepth = 0;
        while(!queue.isEmpty()) {
            NodeAndDepth curr = queue.poll();
            TreeNode currNode = curr.node;
            if (maxDepth < curr.depth) maxDepth = curr.depth;
            if (currNode.left != null) queue.offer(new NodeAndDepth(currNode.left, curr.depth + 1));
            if (currNode.right != null) queue.offer(new NodeAndDepth(currNode.right, curr.depth + 1));
        }
        return maxDepth;
    }

    private static class NodeAndDepth {
        TreeNode node;
        int depth;

        public NodeAndDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        TreeNode testTree = TreeUtil.makeBinaryTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(maxDepth(testTree));
        System.out.println(maxDepthDFS(testTree));
        System.out.println(maxDepthBFS(testTree));
    }
}
