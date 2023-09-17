package LinkedList;

public class MergeTwo {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode itr = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (head == null) {
                    head = list1;
                    itr = head;
                } else {
                    itr.next = list1;
                    itr = itr.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = list2;
                    itr = head;
                } else {
                    itr.next = list2;
                    itr = itr.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            if(head == null){
                head = list1;
            }else{
                itr.next = list1;
            }
        }
        if (list2 != null){
            if(head == null){
                head = list2;
            }else{
                itr.next = list2;
            }
        }
        return head;
    }
}
