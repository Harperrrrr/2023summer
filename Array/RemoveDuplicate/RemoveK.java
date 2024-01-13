package Array.RemoveDuplicate;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

class RemoveK {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int K = k;
        deque.addLast(num.charAt(0));
        for(int i = 1; i < num.length(); ++i){
            while(deque.size() != 0 && deque.getLast() > num.charAt(i) && k > 0){
                deque.removeLast();
                k--;
            }
            deque.addLast(num.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < num.length() - K; ++i){
            ans.append(deque.removeFirst());
        }
        return ans.length() == 0 ? "0" : removeZero(ans);
    }

    public String removeZero(StringBuilder sb){
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return  sb.toString();
    }
}
