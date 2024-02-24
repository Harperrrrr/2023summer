package MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmaller {
    // 315
    int[] arr;
    int[] tmp;
    int[] index;  // 相当于给每个数一个序号
    int[] counts;
    public List<Integer> countSmaller(int[] nums) {
        arr = Arrays.copyOf(nums, nums.length);
        tmp = new int[nums.length];
        counts = new int[nums.length];
        index = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            index[i] = i;
        }

        mergeSort(0, nums.length - 1);

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < counts.length; ++i){
            ans.add(counts[i]);
        }
        return ans;
    }
    public void mergeSort(int start, int end){
        if(start >= end) return;
        int mid = (start + end) >> 1;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        int p1 = start;
        int p2 = mid + 1;
        int tmpIdx = start;
        while(p1 <= mid && p2 <= end){
            if(arr[index[p1]] <= arr[index[p2]]){
                tmp[tmpIdx++] = index[p1];
                counts[index[p1]] += p2 - mid - 1;
                p1++;
            } else if (arr[index[p1]] > arr[index[p2]]){
                tmp[tmpIdx++] = index[p2++];
            }
        }

        while(p1 <= mid){
            tmp[tmpIdx++] = index[p1];
            counts[index[p1]] += end - mid;
            p1++;
        }

        while(p2 <= end){
            tmp[tmpIdx++] = index[p2++];
        }

        for(int i = start; i <= end; ++i){
            index[i] = tmp[i];
        }
    }
}