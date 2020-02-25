package utils;

import pojo.TreeNode;

public class TreeUtil {

    public static TreeNode makeBinaryTree(Integer[] array) {
        return makeBinaryTreeHelper(array, 0);
    }

    private static TreeNode makeBinaryTreeHelper(Integer[] array, int idx) {
        if (idx >= array.length || array[idx] == null) return null;

        TreeNode node = new TreeNode(array[idx]);
        node.left = makeBinaryTreeHelper(array, idx*2 + 1);
        node.right = makeBinaryTreeHelper(array, idx*2 + 2);

        return node;
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }

    public static void printPostOrder(TreeNode root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }
}
