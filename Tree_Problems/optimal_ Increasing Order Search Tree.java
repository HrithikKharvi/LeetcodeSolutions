//Optimal solution for Increasing Order Search Tree
class Solution {
  public TreeNode increasingBST(TreeNode root) {
          return dfs_ad(root, null);
  }
  
   public TreeNode dfs_ad(TreeNode root, TreeNode post){
      if(root == null)return post;

      root.right = dfs_ad(root.right, post);
      TreeNode left = root.left;
      root.left = null;

      return dfs_ad(left, root);
    }
  
}
