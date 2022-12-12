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
class Solution {
    public String tree2str(TreeNode root) {
      if(root == null)return "";
      String finalString = root.val + "";

      finalString += bfs(root.left);
      if(root.left == null && root.right != null)finalString += "()";
      finalString += bfs(root.right);

      return finalString;
    }

    public String bfs(TreeNode root){
      if(root == null)return "";

      String currString = "(" +root.val;
      currString += bfs(root.left);
      if(root.left == null & root.right != null) currString += "()";
      currString += bfs(root.right);
      currString += ")";

      return currString;
    }

}
