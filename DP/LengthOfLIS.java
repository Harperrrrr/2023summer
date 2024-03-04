package DP;

public class LengthOfLIS {//300
    public int lengthOfLIS(int[] num) {
        int[] dp = new int[num.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < num.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (num[j] >= num[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
