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
    public TreeNode convertBST(TreeNode root) {
      dfs(root, 0);
      return root;
    }

    public int dfs(TreeNode root, int top){
      if(root == null)return top;
      int right = dfs(root.right, top);
      root.val += right;
      return dfs(root.left, root.val);
    }

}
