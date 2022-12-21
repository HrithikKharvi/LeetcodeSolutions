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
    public int sumNumbers(TreeNode root) {
      if(root == null)return 0;
        return dfs(root, 0, 10);
    }

    public int dfs(TreeNode root, int sum, int counter){
     if(root.left == null && root.right == null)return sum == 0 ? root.val : (sum * counter) + root.val;

    int currentCount = sum == 0 ? root.val : (sum * counter) + root.val;

    int left = 0;
    int right = 0;

    if(root.left != null)left = dfs(root.left, currentCount, counter);
    if(root.right != null)right = dfs(root.right, currentCount, counter);

    return left + right;

    }

}
