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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      HashMap<Integer, Integer> map = new HashMap<>();

      for(int i=0; i< inorder.length; i++){
        map.put(inorder[i], i);
      }
        return formTree(preorder, inorder, 0, inorder.length, 0, map);
    }

    public TreeNode formTree(int[] preorder, int[] inorder, int start, int end, int curr, HashMap<Integer, Integer> map){
      if(end - start <= 0)return null;
      TreeNode root = new TreeNode(preorder[curr]);
      int currPos = map.get(preorder[curr]);
      int leftCount = currPos - start;

      root.left = formTree(preorder, inorder, start, currPos, curr+1, map);
      root.right = formTree(preorder, inorder, currPos+1, end, curr+leftCount + 1, map);
      return root;
    }

}/**
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      HashMap<Integer, Integer> map = new HashMap<>();

      for(int i=0; i< inorder.length; i++){
        map.put(inorder[i], i);
      }
        return formTree(preorder, inorder, 0, inorder.length, 0, map);
    }

    public TreeNode formTree(int[] preorder, int[] inorder, int start, int end, int curr, HashMap<Integer, Integer> map){
      if(end - start <= 0)return null;
      TreeNode root = new TreeNode(preorder[curr]);
      int currPos = map.get(preorder[curr]);
      int leftCount = currPos - start;

      root.left = formTree(preorder, inorder, start, currPos, curr+1, map);
      root.right = formTree(preorder, inorder, currPos+1, end, curr+leftCount + 1, map);
      return root;
    }

}
