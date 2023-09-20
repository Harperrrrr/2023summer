package Array;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int offset = 0;
        for (int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i-1]){
                offset++;
            }else if(offset > 0){
                nums[i-offset] = nums[i];
            }
        }
        return nums.length - offset;
    }
}
