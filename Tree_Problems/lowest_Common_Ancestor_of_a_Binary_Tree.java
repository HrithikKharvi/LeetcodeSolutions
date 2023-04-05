/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Partial{
  public TreeNode p;
  public TreeNode q;
  public TreeNode parent;
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p,q).parent;
    }

    public Partial findAncestor(TreeNode root, TreeNode p, TreeNode q){
      if(root == null)return null;
      if(root.val == p.val){
        Partial res = new Partial();
        res.p = root;
        if(dfs(root, q)){
          res.q = q;
          res.parent = root;
        }
        System.out.println(p.val);
        return res;
      }

    Partial left = findAncestor(root.left, p, q);
    if(left != null && left.p != null){
      if(left.q != null)return left;
      if(dfs(root, q)){
        left.q = q;
        left.parent = root;
      }
      return left;
    }
    Partial right = findAncestor(root.right, p, q);
    if(right != null && right.p != null){
          if(right.q != null)return right;
          if(dfs(root, q)){
            right.parent = root;
            right.q = q;
            System.out.println(q);
          }
          return right;
        }
    return left == null ? right : left;
    }

    public boolean dfs(TreeNode root, TreeNode q){
      if(root == null)return false;
      if(root.val == q.val)return true;

      return dfs(root.left, q) || dfs(root.right, q);
    }
}
