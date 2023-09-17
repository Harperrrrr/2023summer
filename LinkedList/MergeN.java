package LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeN {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode itr = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode n : lists) {
            if (n != null) {
                minHeap.offer(n);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode n = minHeap.poll();
            if (head == null) {
                head = n;
                itr = head;
            } else {
                itr.next = n;
                itr = itr.next;
            }
            if (n.next != null) {
                minHeap.offer(n.next);
            }
        }
        return head;
    }
}
