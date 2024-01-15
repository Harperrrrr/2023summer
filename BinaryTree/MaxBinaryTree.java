package BinaryTree;

import com.sun.source.tree.Tree;

public class MaxBinaryTree {
    // 654
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int idx = maxIdx(nums, start, end);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = process(nums, start, idx - 1);
        root.right = process(nums, idx + 1, end);
        return root;
    }

    // return max index
    public int maxIdx(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int max_idx = -1;
        for (int i = start; i <= end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                max_idx = i;
            }
        }
        return max_idx;
    }
}
