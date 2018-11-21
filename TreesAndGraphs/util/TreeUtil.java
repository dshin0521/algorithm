package TreesAndGraphs.util;

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

    static void printBinaryTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }
}
