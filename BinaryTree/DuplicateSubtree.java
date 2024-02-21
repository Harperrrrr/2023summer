package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateSubtree {
    private HashMap<String, Integer> map = new HashMap<>();
    private List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        process(root);
        return list;
    }

    public String process(TreeNode root){
        if(root == null){
            return "";
        }
        String res = root.val + '_' +  process(root.left) + '_' + process(root.right);
        int num = map.getOrDefault(res, 0);
        if(num == 1){
            list.add(root);
        }
        map.put(res, ++num);
        return res;
    }
}
