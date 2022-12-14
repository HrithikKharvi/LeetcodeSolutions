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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)return false;
        return dfs_valid(root, root.val);
    }

    public boolean dfs_valid(TreeNode root, int parentValue){
      if(root == null)return true;

      if(root.val != parentValue)return false;

      return dfs_valid(root.left, root.val) && dfs_valid(root.right, root.val);
    }

}
