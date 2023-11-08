package Array.SlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAnagramsSimple {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        if(s.length() < p.length()){
            return ans;
        }
        int[] cur = new int[26];
        int[] obj = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            obj[p.charAt(i) - 'a']++;
            cur[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(obj, cur)) {
            ans.add(0);
        }
        int left = 1;
        int right = left + p.length() - 1;
        while (right < s.length()) {
            cur[s.charAt(right) - 'a']++;
            cur[s.charAt(left - 1) - 'a']--;
            if (Arrays.equals(cur, obj)) {
                ans.add(left);
            }
            right++;
            left++;
        }
        return ans;
    }
}
