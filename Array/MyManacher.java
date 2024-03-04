package Array;

public class MyManacher {
    public String longestPalindrome(String s) {
        s = transform(s);
        char[] ss = s.toCharArray();
        int R = -1;
        // 回文串可以到达的最右端的后一个
        int C = -1;
        int maxR = -1;
        int maxC = -1;
        int[] rArr = new int[ss.length];
        for(int i = 0; i < ss.length; ++i){
            if(i >= R){
                int r = 1;
                while(i + r < ss.length && i - r >= 0 && ss[i + r] == ss[i - r]){
                    r++;
                }
                rArr[i] = r;
            } else {
                int l = 2 * C - i;
                int r;
                if(rArr[l] <= R - i){
                    r = rArr[l];
                } else {
                    r = R - i;
                }
                while(i + r < ss.length && i - r >= 0 && ss[i + r] == ss[i - r]){
                    r++;
                }
                rArr[i] = r;
            }

            if(i + rArr[i] > R){
                R = i + rArr[i];
                C = i;
            }

            if(rArr[i] > maxR){
                maxR = rArr[i];
                maxC = i;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = maxC - maxR + 1; i <= maxC + maxR - 1; ++i){
            if(ss[i] == '#') continue;
            ans.append(ss[i]);
        }

        return ans.toString();
    }
    public String transform(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        return sb.toString();
    }
}