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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;

        for(int i =0; i< preorder.length; i++){
          TreeNode node = new TreeNode(preorder[i]);
          root = dfs(root, node);
        }

        return root;
    }

    public TreeNode dfs(TreeNode root, TreeNode currentNode){
      if(root == null)return currentNode;
      if(root.val > currentNode.val){
        root.left = dfs(root.left, currentNode);
      }else{
        root.right = dfs(root.right, currentNode);
      }

      return root;
    }

}
