package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return preorder(root, ans);
    }

    public List<Integer> preorder(TreeNode root, List<Integer> cur){
        if(root == null){
            return cur;
        }
        cur.add(root.val);
        List<Integer> list = preorder(root.left, cur);
        return preorder(root.right, list);
    }


}
