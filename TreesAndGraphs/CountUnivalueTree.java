package TreesAndGraphs;

/**
 Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 Example :

 Input:  root = [5,1,5,5,5,null,5]

     5
    / \
   1   5
  / \   \
 5   5   5

 Output: 4
 */
public class CountUnivalueTree {

    private static int count = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int countUnivalSubtrees(TreeNode root) {
        countUnivalueSubTreesHelper(root);
        return count;
    }

    private static boolean countUnivalueSubTreesHelper(TreeNode node) {
        if (node == null) return true;
        boolean left = countUnivalueSubTreesHelper(node.left);
        boolean right = countUnivalueSubTreesHelper(node.right);
        if (left && right) {
            if ((node.left != null && node.val != node.left.val)
                || (node.right != null && node.val != node.right.val))
                return false;
            count++;
            return true;
        }
        return false;
    }

    private static TreeNode makeBinaryTree(Integer[] array) {
        return makeBinaryTreeHelper(array, 0);
    }

    private static TreeNode makeBinaryTreeHelper(Integer[] array, int idx) {
        if (idx >= array.length || array[idx] == null) return null;

        TreeNode node = new TreeNode(array[idx]);
        node.left = makeBinaryTreeHelper(array, idx*2 + 1);
        node.right = makeBinaryTreeHelper(array, idx*2 + 2);

        return node;
    }

    private static void printBinaryTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode head = makeBinaryTree(new Integer[]{5,1,5,5,5,null,5});
        System.out.println(countUnivalSubtrees(head));
    }
}
