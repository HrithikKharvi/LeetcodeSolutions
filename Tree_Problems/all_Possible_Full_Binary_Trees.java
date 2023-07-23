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
    public List<TreeNode> allPossibleFBT(int n) {
        return formPossibleFBT(n);
    }

    public List<TreeNode> formPossibleFBT(int n){
      if(n == 1){
        List<TreeNode> list = new ArrayList<>();
        TreeNode base = new TreeNode(0);
        list.add(base);
        return list;
      }

      List<TreeNode> resultList = new ArrayList<>();

      for(int i=1; i<n; i = i + 2){
        List<TreeNode> left = formPossibleFBT(i);
        List<TreeNode> right = formPossibleFBT(n-i-1);

        for(TreeNode l : left){
          for(TreeNode r: right){
            TreeNode root = new TreeNode(0);
            root.left = l;
            root.right = r;

            resultList.add(root);
          }
        }
      }

      return resultList;
    }

}
