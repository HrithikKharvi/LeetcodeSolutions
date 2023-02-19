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

/*
*THIS PROBLEM IS SOLVED WITH THE HELP BREDTH FIRST SEARCH APPROACH AND WITH THE USE OF LINKEDLIST CLASS
*IN THIS PROBLEM WE ITERATE THROUGH THE NODES AND IF THE LEVEL IS ODD THE WE APPEND THE NODE VALUE TO THE REAR OF THE LINKED LIST
*IF THE LEVEL IS EVEN WE APPEND THE NODE VALUE AT THE FRONT OF THE LINKED LIST
*USING QUEUE OF PAIR TO STORE EACH LEVEL NODE AND NODES'S LEVEL
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultArray = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        convert(resultArray, root);
        return resultArray;
    }

    public void convert(List<List<Integer>> returnValue, TreeNode root){
      Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
      queue.add(new Pair(root, 1));
      boolean leftToRight = true;
      int level = 1;
      LinkedList<Integer> linkList = new LinkedList<>();

      while(queue.size() > 0){
        TreeNode curr = queue.peek().getKey();
        int nodeLevel = queue.peek().getValue();
        queue.remove();

        if(nodeLevel != level){
          level++;
          returnValue.add(linkList);
          linkList = new LinkedList<>();
        }

        if(level % 2 != 0){
          linkList.addLast(curr.val);
        }else{
          linkList.addFirst(curr.val);
        }

        if(curr.left != null)queue.add(new Pair(curr.left, level+1));
        if(curr.right != null)queue.add(new Pair(curr.right, level+1));

      }
      if(linkList.size() > 0)returnValue.add(linkList);
    }
}
