package DP;

public class DifferentSubsequence {
    public int numDistinct(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int[][] dp = new int[s_len][t_len];

        for(int i = 0; i < s_len; ++i){
            for(int j = 0; j <= i && j < t_len; ++j){
                if(s.charAt(i) == t.charAt(j)){
                    if(i == 0 && j == 0){
                        dp[i][j] = 1;
                    } else if(j == 0){
                        dp[i][j] = (dp[i - 1][j] + 1) % (1000000007);
                    } else {
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % (1000000007);
                    }
                } else {
                    if(i == 0 && j == 0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length() - 1][t.length() - 1];
    }
}
