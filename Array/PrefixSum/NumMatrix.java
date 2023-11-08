package Array.PrefixSum;

public class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < prefix.length; ++i) {
            for (int j = 0; j < prefix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    prefix[i][j] = 0;
                } else {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1]
                            - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row2 + 1][col1]
                - prefix[row1][col2 + 1] + prefix[row1][col1];
    }
}
