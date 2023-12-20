package Array.BinarySearch;

public class SplitArray {
    // 410 similar to ShipWithinDays
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        // 搜索区间： 分割后可能的最大区间和
        for (Integer i : nums) {
            right += i;
            left = Math.max(left, i);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            int num = numToDivide(nums, mid);
            if (num > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    // 给定最大区间和，需要的分割数
    public int numToDivide(int[] nums, int sum) {
        int cur = 0;
        int num = 0;
        for (Integer i : nums) {
            if (cur + i > sum) {
                num++;
                cur = i;
            } else {
                cur += i;
            }
        }
        return num + 1;
    }
}
