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
    public boolean checkTree(TreeNode root) {
        if(root == null)return false;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

      return root.val == (leftSum + rightSum);
    }

    public int dfs(TreeNode root){
      if(root == null)return 0;
      int left = dfs(root.left);
      int right = dfs(root.right);

      return left + right + root.val;
    }

}
