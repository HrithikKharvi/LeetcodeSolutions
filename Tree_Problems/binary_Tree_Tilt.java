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
    public int findTilt(TreeNode root) {
        inorderChange(root);
        int sum = inorderSum(root);

        return sum;
    }

    public int inorderChange(TreeNode root){
      if(root == null)return 0;

      int left = inorderChange(root.left);
      int right = inorderChange(root.right);
      int rootVal = root.val;
      root.val = Math.abs(left - right);

      return left + right + rootVal;

    }

    public int inorderSum(TreeNode root){
      if(root == null)return 0;

      int left = inorderSum(root.left);
      int right = inorderSum(root.right);

      return left + right + root.val;
    }

}
