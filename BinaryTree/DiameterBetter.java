package BinaryTree;

public class DiameterBetter {
    // 543
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);
        max = Math.max(max, h1 + h2);
        return Math.max(h1, h2) + 1;
    }
}
