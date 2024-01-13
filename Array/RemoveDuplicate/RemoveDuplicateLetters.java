package Array.RemoveDuplicate;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // 记录每个字母出现的次数
        HashMap<Character, Integer> remain = new HashMap<>();
        for (Character c : s.toCharArray()) {
            int num = remain.getOrDefault(c, 0);
            remain.put(c, ++num);
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (seen.contains(c)) {
                remain.put(c, remain.get(c) - 1);
                continue;
            }
            while (sb.length() != 0 && sb.charAt(sb.length() - 1) > c && remain.get(sb.charAt(sb.length() - 1)) > 0) {
                char rm = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                seen.remove(rm);
            }
            sb.append(c);
            remain.put(c, remain.get(c) - 1);
            seen.add(c);
        }

        return sb.toString();
    }
}
