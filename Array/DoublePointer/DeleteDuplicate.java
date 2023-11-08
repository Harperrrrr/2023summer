package Array.DoublePointer;

public class DeleteDuplicate {
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode itr = head.next;
        while(itr != null){
            if(prev.val == itr.val){
                prev.next = itr.next;
            }else{
                prev = prev.next;
            }
            itr = itr.next;
        }
        return head;
    }
}
