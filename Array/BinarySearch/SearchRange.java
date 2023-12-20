package Array.BinarySearch;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (target != nums[mid]) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        left = mid;
        right = mid;
        boolean leftFlag = false;
        boolean rightFlag = false;
        while (true) {
            left--;
            right++;
            if (!leftFlag && (left < 0 || nums[left] != target)) {
                res[0] = left + 1;
                leftFlag = true;
            }
            if (!rightFlag && (right > nums.length - 1 || nums[right] != target)) {
                res[1] = right - 1;
                rightFlag = true;
            }
            if(leftFlag && rightFlag){
                break;
            }
        }
        return res;
    }
}
