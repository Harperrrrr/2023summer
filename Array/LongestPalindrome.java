package Array;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] str = preProcess(s);
        int R = -1;
        int C = -1;
        int[] pArr = new int[str.length];
        int max = Integer.MIN_VALUE;
        int max_c = -1;
        for (int i = 0; i < str.length; ++i) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i - pArr[i] > -1 && i + pArr[i] < pArr.length) {
                if (str[i - pArr[i]] == str[i + pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
                if (i + pArr[i] > R) {
                    R = i + pArr[i];
                    C = i;
                }
                if(pArr[i] > max){
                    max = pArr[i];
                    max_c = i;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = max_c - max + 1; i < max_c + max; ++i) {
            if(str[i]!= '#'){
                ans.append(str[i]);
            }
        }
        return ans.toString();
    }

    public char[] preProcess(String s) {
        char[] charArr = s.toCharArray();
        char[] res = new char[s.length()*2 + 1];
        int idx = 0;
        for (int i = 0; i < res.length; ++i) {
            res[i] = ((i & 1) == 0) ? '#' : charArr[idx++];
        }
        return res;
    }
}
