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
    public List<TreeNode> generateTrees(int n) {
        return formTrees(1, n);
    }

    public List<TreeNode> formTrees(int start, int end){
      if(start > end){
        return new ArrayList<>();
      }
      if(start == end){
        TreeNode node = new TreeNode(start);
        List<TreeNode> resultList = new ArrayList<>();
        resultList.add(node);
        return resultList;
      }

      List<TreeNode> resultList = new ArrayList<>();

      for(int i=start; i <= end; i++){
        List<TreeNode> left = formTrees(start, i-1);
        List<TreeNode> right = formTrees(i+1, end);

        formList(resultList, i, left, right);
      }

      return resultList;
    }

    public void formList(List<TreeNode> result, int root, List<TreeNode> left, List<TreeNode> right){
      if(left.size() == 0 && right.size() > 0){
        for(TreeNode node: right){
          TreeNode rootNode = new TreeNode(root);
          rootNode.right = node;
          result.add(rootNode);
        }

        return;
      }

      if(right.size() == 0 && left.size() > 0){
        for(TreeNode node: left){
          TreeNode rootNode = new TreeNode(root);
          rootNode.left = node;
          result.add(rootNode);
        }

        return;
      }

      if(left.size() > 0 && right.size() > 0){
        for(TreeNode node: right){
          for(TreeNode l : left){
            TreeNode rootNode = new TreeNode(root);
            rootNode.left = l;
            rootNode.right = node;
            result.add(rootNode);
          }
        }

        return;
      }
    }

}
