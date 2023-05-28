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

 //search for element
 //check whether it has right child if node return null so that this node is deleted
 //if the node has right child Find the minimum node from its right child
 //
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
      if(root == null)return null;
        if(key > root.val){
          root.right = deleteNode(root.right, key);
          return root;
        }else if(key < root.val){
          root.left = deleteNode(root.left, key);
          return root;
        }else{
          if(root.right == null && root.left == null)return null;
          if(root.right != null){
            int min = findMin(root.right);
            root.val = min;
            root.right = deleteNode(root.right, min);
          }else{
            int max = findMax(root.left);
            root.val = max;
            root.left = deleteNode(root.left, max);
          }

          return root;
        }
    }

    public int findMin(TreeNode root){
      while(root.left != null)root = root.left;

      return root.val;
    }
    
    public int findMax(TreeNode root){
      while(root.right != null)root = root.right;

      return root.val;
    }

}
