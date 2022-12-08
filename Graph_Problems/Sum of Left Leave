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
    public int sumOfLeftLeaves(TreeNode root) {

      if(root == null)return 0;
      if(root.left == null && root.right == null)return 0;

      return leftSum(root, 0);
    }

    public int leftSum(TreeNode root, int val){
      if(root.left == null && root.right == null)return val == 0 ? 0 : root.val;

      int left = 0;
      int right = 0;

      if(root.left != null)left = leftSum(root.left, 1);
      if(root.right != null) right = leftSum(root.right, 0);

      return left + right;

    }

}
