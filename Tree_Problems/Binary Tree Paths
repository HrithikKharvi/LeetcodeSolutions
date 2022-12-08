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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> arrList = new ArrayList<>();
        if(root == null)return arrList;
        return bfs(root, root.val + "" , arrList);
    }

    public List<String> bfs(TreeNode root, String rootString, ArrayList<String> arr){
      if(root.left == null && root.right == null){
        arr.add(rootString);
        return arr;
      } 

      if(root.left != null) bfs(root.left, rootString + "->" + root.left.val, arr);
      if(root.right != null) bfs(root.right, rootString + "->" + root.right.val, arr);

      return arr;
    }

}
