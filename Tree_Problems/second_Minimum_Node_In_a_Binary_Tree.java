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
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set);

        if(set.size() <2)return -1;
        int first = Integer.MAX_VALUE;
        int second = 0;
        for(Integer ele : set){
          if(ele < first){
            second = first;
            first = ele;
          }else{
            if(ele < second)second = ele;
          }
        }

        return second;
    }

    public void dfs(TreeNode root, Set<Integer> set){
      if(root == null)return;
      dfs(root.left, set);
      set.add(root.val);
      dfs(root.right, set);
    }

}
