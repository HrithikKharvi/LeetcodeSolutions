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
    public int maxSumBST(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        findMax(root, results);
        System.out.println(results);

        int max = Integer.MIN_VALUE;
        for(int i : results){
          max = Math.max(max, i);
        }
        return max > 0 ? max : 0;
    }


    public int findMax(TreeNode root, List<Integer> results){

      if(root.left == null && root.right == null){
        results.add(root.val);
        return root.val;
      }

    int left = 0;
    int right = 0;
    if(root.left != null)left = findMax(root.left, results);
    if(root.right != null)right = findMax(root.right, results);

    if(left == Integer.MAX_VALUE || right == Integer.MAX_VALUE)return Integer.MAX_VALUE;

    if(root.left != null && root.right != null){
      if(find(root.left, false) >= root.val || find(root.right, true) <= root.val)return Integer.MAX_VALUE;
      if(root.val > root.left.val && root.val < root.right.val){
        int sum = left + right + root.val;

        results.add(sum);
        return sum;
      }

      return Integer.MAX_VALUE;
    }

    if(root.left != null){
      if(find(root.left, false) >= root.val)return Integer.MAX_VALUE;
      if(root.val > root.left.val){
        results.add(root.val + left);
        return root.val + left;
      }

      return Integer.MAX_VALUE;
    }

    if(root.right != null){
      if(find(root.right, true) <= root.val)return Integer.MAX_VALUE;
      if(root.val < root.right.val){
        results.add(root.val + right);
        return root.val + right;
      }
      return Integer.MAX_VALUE;
    }

    return Integer.MAX_VALUE;

    }

   public int find(TreeNode root, boolean left){
     if(left){

       while(root.left != null)root = root.left;
       return root.val;
     }else{

       while(root.right != null)root = root.right;
       return root.val;
     }
   }

}
