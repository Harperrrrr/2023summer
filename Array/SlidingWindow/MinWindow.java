package Array.SlidingWindow;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * directly use need[] & need_count to record current situation
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if(s.length() == 1){
            return s.equals(t) ? s : "";
        }
        int[] cur = new int[100];
        int[] obj = new int[100];
        for (int i = 0; i < t.length(); ++i) {
            obj[t.charAt(i) - 'A']++;
        }
        int left = 0;
        int right = -1;
        int resLeft = 0;
        int resRight = 0;
        int minLen = Integer.MAX_VALUE;
        boolean flag = false;
        while (true) {
            while (!include(cur, obj) && right < s.length() - 1) {
                right++;
                char curChar = s.charAt(right);
                cur[curChar - 'A']++;
            }
            if (!include(cur, obj)) {
                if(!flag){
                    return "";
                }
                return s.substring(resLeft, resRight + 1);
            }
            while (true) {
                if (cur[s.charAt(left) - 'A'] - 1 <= obj[s.charAt(left) - 'A']) {
                    break;
                }
                cur[s.charAt(left) - 'A']--;
                left++;
            }
            if (right - left + 1 < minLen) {
                flag = true;
                minLen = right - left + 1;
                resLeft = left;
                resRight = right;
            }
            cur[s.charAt(left) - 'A']--;
            left++;
        }
    }

    public boolean include(int[] cur, int[] obj) {
        for (int i = 0; i < 100; ++i) {
            if (cur[i] < obj[i]) {
                return false;
            }
        }
        return true;
    }
}
