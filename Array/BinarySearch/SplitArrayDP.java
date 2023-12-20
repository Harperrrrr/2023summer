package Array.BinarySearch;

public class SplitArrayDP {
    // 410
    public int splitArray(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            prefixSum[i] = i == 0 ? nums[i] : prefixSum[i - 1] + nums[i];
        }
        // dp[i][j] : 前i个数分成j段 最大和的最小值
        // dp[i][j] = min{max(dp[m][j-1], sum(m+1,i))}
        int[][] dp = new int[nums.length][k];
        for (int i = 0; i < nums.length; ++i) {
            int tmp = Integer.MAX_VALUE;
            dp[i][0] = prefixSum[i];
            for (int j = 1; j <= i && j < k; ++j) {
                //dp[i][j]
                for (int m = j - 1; m < i; ++m){
                    int cur_max = Math.max(dp[m][j-1], prefixSum[i] - prefixSum[m]);
                    tmp = Math.min(cur_max, tmp);
                }
                dp[i][j] = tmp;
            }
        }
        return dp[nums.length - 1][k - 1];
    }
}
