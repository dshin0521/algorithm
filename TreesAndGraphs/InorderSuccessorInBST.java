package TreesAndGraphs;

import utils.TreeUtil;
import utils.TreeNode;

/**
 Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 Note: If the given node has no in-order successor in the tree, return null.

 Example 1:

 Input: root = [2,1,3], p = 1

   2
  / \
 1   3

 Output: 2
 Example 2:

 Input: root = [5,3,6,2,4,null,null,1], p = 6

       5
      / \
     3   6
    / \
   2   4
  /
 1

 Output: null
 */
public class InorderSuccessorInBST {
    /*
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> inorderNodeList = new LinkedList<>();
        inorderSuccessorHelper(root, p, inorderNodeList);
        for (int i = 0; i < inorderNodeList.size(); i++) {
            if (inorderNodeList.get(i).val == p.val) {
                if (i == inorderNodeList.size() - 1) return null;
                return inorderNodeList.get(i+1);
            }
        }
        return null;
    }

    private void inorderSuccessorHelper(TreeNode root, TreeNode p, List<TreeNode> inorderNodeList) {
        if (root == null) return;
        inorderSuccessorHelper(root.left, p, inorderNodeList);
        inorderNodeList.add(root);
        inorderSuccessorHelper(root.right, p, inorderNodeList);
    }
    */

    /*
        Key take away here is that in-order Successor of an input node can be defined as
            the node with the smallest key greater than the key of input node.
        GOAL: Find smallest key greater than the key of input node
     */
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode head = TreeUtil.makeBinaryTree(new Integer[]{5,3,6,2,4,null,null,1});
        System.out.println(inorderSuccessor(head, new TreeNode(6)));

        head = TreeUtil.makeBinaryTree(new Integer[]{2,1,3});
        System.out.println(inorderSuccessor(head, new TreeNode(1)).val);

        head = TreeUtil.makeBinaryTree(new Integer[]{0});
        System.out.println(inorderSuccessor(head, new TreeNode(0)));

        head = TreeUtil.makeBinaryTree(new Integer[]{2,1});
        System.out.println(inorderSuccessor(head, new TreeNode(2)));

    }
}
