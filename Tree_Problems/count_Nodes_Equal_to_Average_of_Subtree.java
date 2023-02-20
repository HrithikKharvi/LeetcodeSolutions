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
    public int averageOfSubtree(TreeNode root) {
        postOrderTraversal(root);
        return count;
    }

    public String postOrderTraversal(TreeNode root){
      if(root == null)return "0:0";
      String leftSum = postOrderTraversal(root.left);
      String rightSum = postOrderTraversal(root.right);

      int leftCount = Integer.parseInt(leftSum.split(":")[0]);
      int leftNodes = Integer.parseInt(leftSum.split(":")[1]);
      int rightCount = Integer.parseInt(rightSum.split(":")[0]);
      int rightNodes = Integer.parseInt(rightSum.split(":")[1]);

      int nodeSum = leftNodes + rightNodes + 1;
      int nodeCount = leftCount + rightCount + root.val;


      if((nodeCount / nodeSum) == root.val)count++;

      return nodeCount + ":" + nodeSum;

    }

}
