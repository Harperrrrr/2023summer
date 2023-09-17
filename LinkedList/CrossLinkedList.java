package LinkedList;

public class CrossLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itrA = headA;
        ListNode itrB = headB;
        while (true) {
            if (itrA.next == null || itrB.next == null) {
                break;
            }
            itrA = itrA.next;
            itrB = itrB.next;
        }
        if (itrA.next == null) {
            itrA = headB;
            while (itrB.next != null) {
                itrA = itrA.next;
                itrB = itrB.next;
            }
            itrB = headA;
        } else {
            itrB = headA;
            while (itrA.next != null) {
                itrA = itrA.next;
                itrB = itrB.next;
            }
            itrA = headB;
        }
        while (itrB != itrA){
            if(itrA.next == null||itrB.next == null){
                return null;
            }
            itrA = itrA.next;
            itrB = itrB.next;
        }
        return itrB;
    }
}
