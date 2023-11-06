import Array.FindAnagrams;
import Array.LongestSubstring;
import Array.SpiralOrderShitVersion;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        FindAnagrams fa = new FindAnagrams();
        List<Integer> ans = fa.findAnagrams(s,"abc");
        System.out.println(ans);
    }
}
