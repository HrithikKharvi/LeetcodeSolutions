//==================Approach===============
//* For root we are passing count as 0 as initial count
//* We do dfs here, we go till end of left node and while returning back we check each node whether root value is in the range
//* If it is in range we add it to the count that is passed to the function
//* we pass the count that we got from iterating left node into the right node
//* We follow the same step that we done for left node and return the count

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
    public int rangeSumBST(TreeNode root, int low, int high) {
     return dfs(root, low, high, 0);   
    }

    public int dfs(TreeNode root, int low, int high, int count){
      if(root == null)return count;

      count = dfs(root.left, low, high, count);
      if(root.val >= low && root.val <= high){
          System.out.println(root.val + " -> " + count);
          count +=root.val;
      }
      count = dfs(root.right, low, high, count);
      return count;
    }

}
