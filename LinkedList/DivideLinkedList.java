package LinkedList;

public class DivideLinkedList {
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
    public ListNode partition(ListNode head, int x) {
        ListNode ans = new ListNode(-1);
        ListNode part = ans;
        ListNode tail = ans;
        ListNode itr = head;
        while(itr != null){
            if(itr.val < x){
                ListNode next = part.next;
                part.next = itr;
                ListNode next2 = itr.next;
                itr.next = next;
                tail = tail == part ? part.next : tail;
                part = part.next;
                itr = next2;
            }else{
                tail.next = itr;
                tail = tail.next;
                itr = itr.next;
                tail.next = null;
            }
        }
        return ans.next;
    }
}
