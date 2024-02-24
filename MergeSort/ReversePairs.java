package MergeSort;

import java.util.Arrays;

//170
public class ReversePairs {
    int ans = 0;
    int[] arr;
    int[] tmp;
    public int reversePairs(int[] record) {
        arr = Arrays.copyOf(record, record.length);
        tmp = new int[arr.length];
        mergeSort(0, arr.length - 1);
        return ans;
    }
    public void mergeSort(int start, int end){
        if(start == end) return;
        int mid = (start + end) >> 1;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        int p1 = start;
        int p2 = mid + 1;
        int tmpIdx = start;
        while(p1 <= mid && p2 <= end){
            if(arr[p1] < arr[p2]){
                tmp[tmpIdx++] = arr[p1++];
            } else if(arr[p1] > arr[p2]){
                ans += mid - p1 + 1;
                tmp[tmpIdx++] = arr[p2++];
            } else {
                tmp[tmpIdx++] = arr[p1++];
//                tmp[tmpIdx++] = arr[p2++];
            }
        }

        while(p1 <= mid){
            tmp[tmpIdx++] = arr[p1++];
        }

        while(p2 <= end){
            tmp[tmpIdx++] = arr[p2++];
        }

        for(int i = start; i <= end; ++i){
            arr[i] = tmp[i];
        }
    }
}
