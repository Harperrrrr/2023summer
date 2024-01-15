package BinaryTree;

public class FromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder, inorder, 0, 0, preorder.length);
    }

    public TreeNode process(int[] preorder, int[] inorder, int preStart, int inStart, int len){
        if(len <= 0){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int curLen = 0;
        for(int i = inStart; i < inStart + len; ++i){
            if(inorder[i] == rootVal){
                curLen = i - inStart;
                break;
            }
        }
        root.left = process(preorder, inorder, preStart + 1, inStart, curLen);
        root.right = process(preorder, inorder, preStart + 1 + curLen, inStart + curLen + 1, len - 1 - curLen);
        return root;
    }
}
