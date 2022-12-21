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
    public boolean isEvenOddTree(TreeNode root) {
      Map<Integer, Integer> map = new HashMap<>();
        return dfs(root, 0, map);
    }

    public boolean dfs(TreeNode root, int level, Map<Integer, Integer> map){
      if(root == null)return true;
      System.out.println(root.val +":" + level);
      int rootVal = root.val;
      int prev = -1;
      if(map.containsKey(level))prev = map.get(level);
      System.out.println(prev);
      if(level % 2 == 0){
        if(rootVal % 2 != 1 || (prev != -1 && prev >= rootVal)){
          return false;
        }
      }else{
        if(rootVal % 2 != 0 || (prev != -1 && prev <= rootVal)){
          return false;
        }
      }

      map.put(level, rootVal);
        boolean left = dfs(root.left, level + 1, map);
        boolean right = dfs(root.right, level+1, map);

        return left && right;

    }

}
