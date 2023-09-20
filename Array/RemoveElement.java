package Array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int offset = 0;
        for (int i = 0; i < nums.length; ++i) {
            if(nums[i] == val){
                offset++;
            }else if(offset > 0){
                nums[i-offset] = nums[i];
            }
        }
        return nums.length - offset;
    }
}
