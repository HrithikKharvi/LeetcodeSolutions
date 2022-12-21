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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root, arr);

        for(int i=0; i< arr.size()-1; i++){
          TreeNode curr = arr.get(i);
          curr.left = null;
          curr.right = arr.get(i+1);
        }

    }

    public void dfs(TreeNode root, ArrayList<TreeNode> arr){
      if(root == null)return;
      arr.add(root);
      dfs(root.left, arr);
      dfs(root.right, arr);
    }

}
