/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;

        boolean pOnLeft = root.val > p.val ? true : false;
        boolean qOnLeft = root.val > q.val ? true : false;

        if(pOnLeft != qOnLeft)return root;

        TreeNode side = pOnLeft ? root.left : root.right;

        return lowestCommonAncestor(side, p, q);
    }
}
