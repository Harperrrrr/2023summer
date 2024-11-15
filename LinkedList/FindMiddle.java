package LinkedList;

public class FindMiddle {
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

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            if(fast == null){
                return slow;
            }
            if(fast.next == null){
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
