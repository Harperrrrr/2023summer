package DP;

// 931
public class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 1){
            return matrix[0][0];
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 101;
        for(int i = 0; i < matrix[0].length; ++i){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                dp[i][j] = getMin(dp, i, j) + matrix[i][j];
                if(i == matrix.length - 1){
                    ans = Math.min(dp[i][j], ans);
                }
            }
        }

        return ans;
    }

    public int getMin(int[][] dp, int i, int j){
        int min = 0;
        if(j == 0){
            min = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
        } else if(j == dp[0].length - 1){
            min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
        } else {
            min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            min = Math.min(min, dp[i - 1][j + 1]);
        }
        return min;
    }
}
