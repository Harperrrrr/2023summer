package Array.RemoveDuplicate;

import java.util.*;

public class ConcatMaxNumber {
    // 321 similar to RemoveK
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // i    k-i
        int[] ans = new int[k];
        for (int i = 0; i <= k; ++i) {
            if (i > nums1.length || (k - i) > nums2.length) {
                continue;
            }
            int[] tmp = merge(chooseK(nums1, i), chooseK(nums2, k - i));
            if (Arrays.compare(ans, tmp) < 0) {
                ans = Arrays.copyOf(tmp, tmp.length);
            }
        }
        return ans;
    }

    public int[] chooseK(int[] num, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int toDump = num.length - k;
        for (Integer i : num) {
            while (!deque.isEmpty() && deque.getLast() < i && toDump > 0) {
                deque.removeLast();
                toDump--;
            }
            deque.addLast(i);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = deque.removeFirst();
        }
        return ans;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int[] ans = new int[nums1.length + nums2.length];
        int idx = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                ans[idx++] = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]){
                ans[idx++] = nums2[p2++];
            } else {
                // 挑选字典序大的数组 放入ans
                int t1 = p1;
                int t2 = p2;
                while(t1 < nums1.length && t2 < nums2.length && nums1[t1] == nums2[t2]){
                    t1++;
                    t2++;
                }
                if(t1 == nums1.length || t2 != nums2.length && nums1[t1] < nums2[t2]){
                    ans[idx++] = nums2[p2++];
                } else {
                    ans[idx++] = nums1[p1++];
                }
            }
        }
        while(p1 < nums1.length){
            ans[idx++] = nums1[p1++];
        }
        while(p2 < nums2.length){
            ans[idx++] = nums2[p2++];
        }
        return ans;
    }
}
