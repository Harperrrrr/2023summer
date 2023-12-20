package Array;

import java.util.Arrays;
import java.util.Comparator;

public class HorseRacing {
    // 870
    // 田忌的下等马和齐威王的下等马比，比过，赚/比不过，送人头，比上等马
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        // nums2顺序不能改变，因此开辟记录排序之后索引的数组
        Integer[] nums2SortIdx = new Integer[nums2.length];
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums2SortIdx.length; ++i) {
            nums2SortIdx[i] = i;
        }
        Arrays.sort(nums2SortIdx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums2[o1] - nums2[o2];
            }
        });

        int left = 0;
        int right = nums2.length - 1;
        for (int i = 0; i < nums1.length; ++i) {
            if(left > right){
                break;
            }
            if (nums1[i] > nums2[nums2SortIdx[left]]) {
                ans[nums2SortIdx[left]] = nums1[i];
                left++;
            } else {
                ans[nums2SortIdx[right]] = nums1[i];
                right--;
            }
        }
        return ans;
    }
}
