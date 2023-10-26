package Array;

public class NumArray {
    private int[] prefix;
    private int[] array;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        array = new int[nums.length];
        int idx = 0;
        int cur_sum = 0;
        for (Integer i : nums) {
            cur_sum += i;
            prefix[idx++] = cur_sum;
            array[idx++] = i;
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right] - prefix[left] + array[left];
    }
}
