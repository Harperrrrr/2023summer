package Array.SlidingWindow;

public class MinWindowSimple {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || t.length() == 0){
            return "";
        }
        int[] need = new int[100];
        int need_count = t.length();
        for (char c : t.toCharArray()) {
            need[c - 'A']++;
        }
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (--need[s.charAt(right) - 'A'] >= 0) {
                need_count--;
            }
            if (need_count == 0) {
                while (true) {
                    if (need[s.charAt(left) - 'A'] < 0) {
                        need[s.charAt(left) - 'A']++;
                        left++;
                    } else {
                        break;
                    }
                }
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minRight = right;
                    minLeft = left;
                }
                need[s.charAt(left) - 'A']++;
                left++;
                need_count++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }
}
