package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 *
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node next;
 * }
 *
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 *
 * Example 1:
 *              1
 *            /   \
 *           2     3
 *         /  \   /  \
 *        4   5  6   7
 *
 *              1 --> NULL
 *            /   \
 *          /      \
 *         2 ---->  3 --> NULL
 *      /   \     /  \
 *     4 -> 5 -> 6 -> 7 --> NULL
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is less than 4096.
 * -1000 <= node.val <= 1000
 */
public class PopulatingNextRightPtrsInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

//    public static Node connect(Node root) {
//        if (root == null) return null;
//
//        root.next = null;
//        if (root.left == null || root.right == null) return root;
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root.left);
//        queue.add(root.right);
//
//        while (!queue.isEmpty()) {
//            int queueSize = queue.size();
//            int i = 1;
//            Node prev = queue.poll();
//            Node curr;
//            while (i < queueSize) {
//                if (prev.left != null) queue.add(prev.left);
//                if (prev.right != null) queue.add(prev.right);
//
//                curr = queue.poll();
//                if (curr.left != null) queue.add(curr.left);
//                if (curr.right != null) queue.add(curr.right);
//
//                prev.next = curr;
//                prev = curr;
//                i++;
//            }
//            prev.next = null;
//        }
//
//        return root;
//    }

    public static Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            if (root.next != null) root.right.next = root.next.left;
            else root.right.next = null;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}
