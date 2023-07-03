/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
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

public class ListReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode beforeHead = new ListNode(0,head);
        if (left == right) {
            return head;
        }
        ListNode n1 = null, n2 = null;
        ListNode itr = beforeHead;
        for (int i = 0; ;++i){
            if(i == left - 1){
                n1 = itr;
            }
            if(i == right){
                n2 = itr;
                break;
            }
            itr = itr.next;
        }
        reverse(n1,n2);
        return beforeHead.next;
    }

    public ListNode reverse(ListNode beforeHead, ListNode tail) {
        if (beforeHead.next == tail) {
            return tail;
        }
        ListNode head = beforeHead.next;
        ListNode next = tail.next;
        ListNode t = reverse(head, tail);
        beforeHead.next = tail;
        t.next = head;
        head.next = next;
        return head;
    }
}