/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PreBinary {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public String tree2str(TreeNode root) {
        String ans="";
        return visit(root,ans);
    }
    public String visit(TreeNode root,String ans){
        if(root==null){
            return ans;
        }
        ans+=String.valueOf(root.val);
        if(root.left==null && root.right==null){

        }else if(root.right==null){
            ans+='(';
            ans=visit(root.left,ans);
            ans+=')';
        }else{
            ans+=')';
            ans=visit(root.left,ans);
            ans+=')';
            ans+=')';
            ans=visit(root.right,ans);
            ans+=')';
        }
        return ans;
    }
}