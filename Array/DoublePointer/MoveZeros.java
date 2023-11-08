package Array.DoublePointer;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                offset++;
            } else if (offset > 0) {
                nums[i - offset] = nums[i];
            }
        }
        for (int i = nums.length - 1, j = 0; j < offset; --i, ++j) {
            nums[i] = 0;
        }
    }
}
