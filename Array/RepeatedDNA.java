package Array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串哈希 & 前缀和
 */
public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        int N = (int) 1e5 + 10;
        int P = 13131;
        int[] h = new int[N];
        int[] p = new int[N]; //次方数组 下标含义为指数
        p[0] = 1;
        h[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i);
        }
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        /**
         * key:hash
         * value:count
         */
        map.put(h[9], 1);
        List<String> ans = new LinkedList<>();
        for (int i = 1, j = 10; j < s.length(); ++i, ++j) {
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            int cnt = map.getOrDefault(hash, 0);
            if(cnt == 1){
                ans.add(s.substring(i, j + 1));
            }
            map.put(hash, cnt + 1);
        }
        return ans;
    }
}
