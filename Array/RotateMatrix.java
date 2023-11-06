package Array;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        for (int i = 0; i <= matrix.length / 2; ++i) {
            for (int j = i; j < matrix.length - 1 - i; ++j) {
                int up = matrix[i][j];
                int right = matrix[j][matrix.length - 1 - i];
                int down = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                int left = matrix[matrix.length - 1 - j][i];
                matrix[j][matrix.length - 1 - i] = up;
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = right;
                matrix[matrix.length - 1 - j][i] = down;
                matrix[i][j] = left;
            }
        }
    }
}
