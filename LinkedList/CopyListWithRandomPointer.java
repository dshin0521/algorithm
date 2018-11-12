package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 Return a deep copy of the list.

 Great solution:
 https://leetcode.com/explore/interview/card/yelp/37/linked-list-4/222/discuss/43515/My-accepted-Java-code.-O(n)-but-need-to-iterate-the-list-3-times
 */
public class CopyListWithRandomPointer {
    public static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;

        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    private static RandomListNode generateRandomListNodes(int length) {
        Map<Integer, RandomListNode> map = new HashMap<>();
        map.put(0, new RandomListNode(0));
        RandomListNode head = map.get(0);
        RandomListNode node = head;
        for (int i = 1; i < length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new RandomListNode(i));
            }
            node.next = map.get(i);
            int randomValue = new Random().nextInt(length);
            if (!map.containsKey(randomValue)) {
                map.put(randomValue, new RandomListNode(randomValue));
            }
            node.random = map.get(randomValue);
            node = node.next;
        }
        node.next = null;
        node.random = map.get(new Random().nextInt(length));
        return head;
    }

    private static void compareTwoRandomLists(RandomListNode origin, RandomListNode copy) {
        RandomListNode originNode = origin;
        RandomListNode copyNode = copy;
        while (originNode != null) {
            System.out.println("Original input");
            System.out.println("mem address: " + originNode);
            System.out.println("value: " + originNode.label +
                    ", random: " + (originNode.random == null ? "null" : originNode.random.label));

            System.out.println("Copy of input");
            System.out.println("mem address: " + copyNode);
            System.out.println("value: " + copyNode.label +
                    ", random: " + (copyNode.random == null ? "null" : copyNode.random.label));
            originNode = originNode.next;
            copyNode = copyNode.next;
        }
    }
    public static void main(String[] args) {
        RandomListNode head = generateRandomListNodes(10);
        RandomListNode copyHead = copyRandomList(head);
        compareTwoRandomLists(head, copyHead);
    }
}
