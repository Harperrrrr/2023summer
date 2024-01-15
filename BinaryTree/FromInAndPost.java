package BinaryTree;

public class FromInAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return process(inorder, postorder, 0, 0, inorder.length);
    }

    public TreeNode process(int[] inorder, int[] postorder, int inStart, int postStart, int len){
        if(len <= 0){
            return null;
        }
        int rootVal = postorder[postStart + len - 1];
        int curLen = 0;
        TreeNode root = new TreeNode(rootVal);
        for(int i = inStart; i < inStart + len; ++i){
            if(inorder[i] == rootVal){
                curLen = i - inStart;
                break;
            }
        }
        root.left = process(inorder, postorder, inStart, postStart, curLen);
        root.right = process(inorder, postorder, inStart + curLen + 1, postStart + curLen, len - 1 - curLen);
        return root;
    }
}
