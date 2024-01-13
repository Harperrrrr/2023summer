package BinaryTree;

public class Diameter {
    // 543
    public int diameterOfBinaryTree(TreeNode root) {
        return process(root)[1];
    }
    // 返回最大高度和最大直径
    public int[] process(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] res1 = process(root.left);
        int[] res2 = process(root.right);
        int height = Math.max(res1[0], res2[0]) + 1;
        int diameter = Math.max(res1[1], res2[1]);
        diameter = Math.max(diameter, res1[0] + res2[0]);
        return new int[]{height, diameter};
    }
}
