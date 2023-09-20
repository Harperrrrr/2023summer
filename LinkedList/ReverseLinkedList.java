package LinkedList;

public class ReverseLinkedList {
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

    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode cur_head = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur_head;
    }
}
