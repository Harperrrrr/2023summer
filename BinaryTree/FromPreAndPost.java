package BinaryTree;

import com.sun.source.tree.Tree;

public class FromPreAndPost {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return process(preorder, postorder, 0, 0, preorder.length);
    }

    public TreeNode process(int[] preorder, int[] postorder, int preStart, int postStart, int len) {
        if (len <= 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int leftLen = 0;
        int leftRootVal = preorder[preStart + 1];
        for (int i = postStart; i < postStart + len; ++i) {
            if (postorder[i] == leftRootVal) {
                leftLen = i - postStart + 1;
            }
        }
        root.left = process(preorder, postorder, preStart + 1, postStart, leftLen);
        root.right = process(preorder, postorder, preStart + 1 + leftLen, postStart + leftLen, len - 1 - leftLen);
        return root;
    }

}
