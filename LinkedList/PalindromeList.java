package LinkedList;

import java.util.Stack;

public class PalindromeList {
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<ListNode> stack = new Stack<>();
        while(true){
            if(fast == null){
                break;
            }
            if(fast.next == null){
                slow = slow.next;
                break;
            }
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        while(!stack.isEmpty()){
            ListNode tmp = stack.pop();
            if(slow == null || tmp.val != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
