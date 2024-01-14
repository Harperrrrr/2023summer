package BinaryTree;

public class Flatten2List {
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode();
        process(root, head);
    }

    // 返回处理后的list tail
    public TreeNode process(TreeNode root, TreeNode listTail){
        if(root == null){
            return listTail;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        listTail.right = root;
        listTail = root;
        TreeNode newTail = process(left, listTail);
        return process(right, newTail);
    }
}
