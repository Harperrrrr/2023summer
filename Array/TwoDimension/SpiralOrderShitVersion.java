package Array.TwoDimension;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderShitVersion {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; ++i) {
                ans.add(matrix[0][i]);
            }
            return ans;
        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; ++i) {
                ans.add(matrix[i][0]);
            }
            return ans;
        }
        Direction dir = Direction.right;
        int i = 0;
        int j = 0;
        int margin = 0;
        while (true) {
            switch (dir) {
                case right:
                    for (; j < matrix[0].length - 1 - margin; ++j) {
                        ans.add(matrix[i][j]);
                    }
                    dir = Direction.down;
                    break;
                case down:
                    for (; i < matrix.length - 1 - margin; ++i) {
                        ans.add(matrix[i][j]);
                    }
                    dir = Direction.left;
                    break;
                case left:
                    for (; j > margin; --j) {
                        ans.add(matrix[i][j]);
                    }
                    dir = Direction.up;
                    break;
                case up:
                    for (; i > margin; --i) {
                        ans.add(matrix[i][j]);
                    }
                    dir = Direction.right;
                    boolean fi = processFinal(margin, matrix, ans);
                    if (fi) {
                        return ans;
                    }
                    margin++;
                    i++;
                    j++;
                    break;
            }
        }
    }

    public boolean processFinal(int margin, int[][] matrix, List<Integer> ans) {
        int height = matrix.length;
        int width = matrix[0].length;
        if (height % 2 == 0 && margin + 1 == height / 2) {
            return true;
        } else if (height % 2 == 1 && margin + 1 == height / 2) {
            margin++;
            for (int j = margin; j <= matrix[0].length - 1 - margin; ++j) {
                ans.add(matrix[margin][j]);
            }
            return true;
        } else if (width % 2 == 0 && margin + 1 == width / 2) {
            return true;
        } else if (width % 2 == 1 && margin + 1 == width / 2) {
            margin++;
            for (int i = margin; i <= matrix.length - 1 - margin; ++i) {
                ans.add(matrix[i][margin]);
            }
            return true;
        }
        return false;
    }

    public enum Direction {
        right, down, left, up
    }
}
