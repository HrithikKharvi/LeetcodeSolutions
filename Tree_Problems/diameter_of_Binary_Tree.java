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
    public int diameterOfBinaryTree(TreeNode root) {

      Set<Integer> set = new HashSet<>();

      dfs(root, set, 0);
      
      int max = 0;

      for(Integer val : set){
        if(val > max)max = val;
      }

      return max;
    }

    public int dfs(TreeNode root, Set<Integer> set, int prev){
      if(root == null)return 0;

      int leftVal = dfs(root.left, set, prev + 1);
      int rightVal = dfs(root.right, set, prev + 1);

      set.add(leftVal + prev);
      set.add(rightVal + prev);
      set.add(leftVal + rightVal);

      int max = Math.max(leftVal, rightVal);

      return max+1;

    }

}
