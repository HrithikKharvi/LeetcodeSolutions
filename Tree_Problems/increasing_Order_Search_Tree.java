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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();

        dfs(root, arr);

        for(int i=0; i< arr.size()-1; i++){
          arr.get(i).right = arr.get(i+1);
          arr.get(i).left = null;
        }

        if(root != null){
        arr.get(arr.size() - 1).left = null;
        arr.get(arr.size() - 1).right = null;
        }else{
          return null;
        }
        return arr.get(0);
    }

    public void dfs(TreeNode root, ArrayList<TreeNode> arr){
      if(root == null)return;

      dfs(root.left, arr);
      arr.add(root);
      dfs(root.right, arr);

    }

}
