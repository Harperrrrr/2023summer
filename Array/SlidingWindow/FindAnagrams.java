package Array.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> cur_map = new LinkedHashMap<>();
        HashMap<Character, Integer> obj_map = new LinkedHashMap<>();
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        int valid_char = 0;
        for (Character c : p.toCharArray()) {
            if (obj_map.containsKey(c)) {
                obj_map.put(c, obj_map.get(c) + 1);
            } else {
                obj_map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            right = i;
            char c = s.charAt(i);
            if (!obj_map.containsKey(c)) {
                left = i + 1;
                cur_map.clear();
                valid_char = 0;
                continue;
            }
            if (cur_map.containsKey(c)) {
                cur_map.put(c, cur_map.get(c) + 1);
            } else {
                cur_map.put(c, 1);
            }
            if (cur_map.get(c).equals(obj_map.get(c))) {
                valid_char++;
            }
            if (right - left + 1 > p.length()) {
                char to_delete = s.charAt(left);
                if(cur_map.get(to_delete).equals(obj_map.get(to_delete))){
                    valid_char--;
                }
                cur_map.put(to_delete, cur_map.get(to_delete) - 1);
                left++;
            }
            if (valid_char == obj_map.keySet().size()) {
                ans.add(left);
            }
        }
        return ans;
    }
}
