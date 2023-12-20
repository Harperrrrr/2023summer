package Array.BinarySearch;

public class SearchRangeBetter {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            } else if(target > nums[mid]){
                left = mid + 1;
            } else {
                first = mid;
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            } else if(target > nums[mid]){
                left = mid + 1;
            } else {
                last = mid;
                left = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}
