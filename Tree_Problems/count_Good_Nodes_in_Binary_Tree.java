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
  int count = 0;
    public int goodNodes(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;

        dfs(root, maxVal);
        return count;
    }

    public void dfs(TreeNode root, int maxVal){
      if(root == null)return;
      System.out.println(root.val + ">" + maxVal);
      if(root.val >= maxVal)count++;
      maxVal = Math.max(maxVal, root.val);

      dfs(root.left, maxVal);
      dfs(root.right, maxVal);
    }

}
