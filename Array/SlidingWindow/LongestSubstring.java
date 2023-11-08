package Array.SlidingWindow;

import java.util.HashMap;

public class LongestSubstring {
    /**
     * find the longest substring without replicate characters
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max_len = 0;
        for (int i = 0; i < s.length(); ++i) {
            Integer k = map.get(s.charAt(i));
            right = i;
            if (k != null && k >= left) {
                left = k + 1;
            } else {
                max_len = Math.max(max_len, right - left + 1);
            }
            map.put(s.charAt(i), i);
        }
        return max_len;
    }
}
