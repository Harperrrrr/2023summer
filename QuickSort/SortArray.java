package QuickSort;

import java.util.Random;

public class SortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        Random rand = new Random();
        int idx = start + rand.nextInt(end - start + 1);
        int pivot = nums[idx];
        int p1 = start;
        int p2 = end;
        while(p1 <= p2){
            if(nums[p1] > pivot){
                swap(nums, p1, p2--);
            } else {
                p1++;
            }

            if(p1 > p2) break;

            if(nums[p2] < pivot){
                swap(nums, p1++, p2);
            } else {
                p2--;
            }
        }

        quickSort(nums, start, p2);
        quickSort(nums, p1, end);
    }

    public void swap(int[] nums, int i1, int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
