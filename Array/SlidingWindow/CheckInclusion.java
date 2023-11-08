package Array.SlidingWindow;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> curMap = new LinkedHashMap<>();
        HashMap<Character, Integer> objMap = new LinkedHashMap<>();
        for (Character c : s1.toCharArray()) {
            if (objMap.containsKey(c)) {
                objMap.put(c, objMap.get(c) + 1);
            } else {
                objMap.put(c, 1);
            }
        }
        int right;
        int left = 0;
        int validChar = 0;
        for (int i = 0; i < s2.length(); ++i) {
            right = i;
            char curChar = s2.charAt(i);
            if (!objMap.containsKey(curChar)) {
                left = right + 1;
                curMap.clear();
                validChar = 0;
                continue;
            } else {
                if (curMap.containsKey(curChar)) {
                    curMap.put(curChar, curMap.get(curChar) + 1);
                } else {
                    curMap.put(curChar, 1);
                }
            }
            if (curMap.get(curChar).equals(objMap.get(curChar))) {
                validChar++;
            }
            if ((right - left + 1) > s1.length()) {
                char toDelete = s2.charAt(left);
                if (curMap.get(toDelete).equals(objMap.get(toDelete))) {
                    validChar--;
                }
                curMap.put(toDelete, curMap.get(toDelete) - 1);
                left++;
            }
            if(validChar == objMap.size()){
                return true;
            }
        }
        return false;
    }
}
