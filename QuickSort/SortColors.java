package QuickSort;

public class SortColors {
    public void sortColors(int[] nums) {
        quickSort(nums);
    }

    public void quickSort(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;

        // p1, p2永远指向当前需要被检查的数
        while (p1 < p2) {
            if (nums[p1] >= 1) {
                swap(nums, p1, p2--);
            } else {
                p1++;
            }

            if (nums[p2] == 0) {
                swap(nums, p1++, p2);
            } else {
                p2--;
            }
        }

        //现在重排右段
        p2 = nums.length - 1;

        while (p1 < p2) {
            if (nums[p1] == 2) {
                swap(nums, p1, p2--);
            } else {
                p1++;
            }

            if (nums[p2] == 1) {
                swap(nums, p1++, p2);
            } else {
                p2--;
            }
        }
    }

    public void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}