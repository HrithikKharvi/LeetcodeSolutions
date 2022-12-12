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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        inorder(root, arr);
        for(int i=0; i< arr.size()-1; i++){
          System.out.println(arr.get(i));
          int currentMin = Math.abs(arr.get(i) - arr.get(i+1));
          if(currentMin < min)min = currentMin;
        }

        if(root == null)return 0;
        if(arr.size() == 1)return root.val;

        return min;

    }

    public void inorder(TreeNode root, ArrayList<Integer> arr){
      if(root == null)return;

      inorder(root.left, arr);
      arr.add(root.val);
      inorder(root.right, arr);
    }

}
