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
    public int minDiffInBST(TreeNode root) {
     ArrayList<Integer> arr = new ArrayList<>();
     inorder(root, arr);

      int min = Integer.MAX_VALUE;

      if(arr.size() < 2)return 0;
      for(int i=0; i<arr.size()-1; i++){
        int currentSum = arr.get(i+1) - arr.get(i);
        if(currentSum < min)min = currentSum;
      }

      return min;

    }

    public void inorder(TreeNode root, ArrayList<Integer> arr){
      if(root == null)return;

      inorder(root.left, arr);
      arr.add(root.val);
      inorder(root.right, arr);
    }

}
