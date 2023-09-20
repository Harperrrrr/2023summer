package LinkedList;

public class ReverseK {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getListLength(head);
        return reverseAllK(head,k,len);
    }

    public ListNode reverseFirstK(ListNode head, int k, int len) {
        if (head == null) {
            return head;
        }
        if (k > len || k == 1) {
            return head;
        }
        ListNode cur_head = reverseFirstK(head.next, k - 1, len - 1);
        ListNode next = head.next.next;
        head.next.next = head;
        head.next = next;
        return cur_head;
    }

    public int getListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode reverseAllK(ListNode head, int k, int len) {
        if (k > len) {
            return head;
        }
        ListNode cur_head = reverseFirstK(head, k, len);
        ListNode next = head.next;
        ListNode t = reverseAllK(next, k, len - k);
        head.next = t;
        return cur_head;
    }
}
