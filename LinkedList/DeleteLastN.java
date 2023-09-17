package LinkedList;

public class DeleteLastN {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode itr1 = head;
        ListNode itr2 = head;
        while(--n > 0){
            itr1 = itr1.next;
        }
        ListNode prev = null;
        while(itr1.next != null){
            itr1 = itr1.next;
            prev = itr2;
            itr2 = itr2.next;
        }
        if(prev != null){
            prev.next = itr2.next;
            return head;
        }else{
            return head.next;
        }
    }
}
