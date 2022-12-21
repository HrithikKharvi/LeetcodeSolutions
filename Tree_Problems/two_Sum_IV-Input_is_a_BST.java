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
    public boolean findTarget(TreeNode root, int k) {
       Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
       return inorderDFS(root, k, map); 
    }

    public boolean inorderDFS(TreeNode root, int k, Map<Integer, Boolean> map){
      if(root == null)return false;
      if(map.containsKey(root.val))return true;
      map.put(k - root.val, true);

      boolean left = inorderDFS(root.left, k, map);
      boolean right = inorderDFS(root.right, k, map);

      return left || right;
    }

}
