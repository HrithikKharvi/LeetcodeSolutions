/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int length = findLength(head);
        return getBST(head, 0, length);
    }

    public TreeNode getBST(ListNode head, int start, int end){
      if(end - start < 1)return null;
      int mid = (start + end) / 2;
      ListNode currentNode = findListNode(head, mid);
      TreeNode root = new TreeNode(currentNode.val);
      root.left = getBST(head, start, mid);
      root.right = getBST(head, mid+1, end);
      return root;
    }

    public ListNode findListNode(ListNode head, int point){
      int counter = 0;
      while(counter != point){
        head = head.next;
        counter++;
      }

      return head;
    }

  public int findLength(ListNode head){
    int count = 0;
    while(head != null){
      head = head.next;
      count++;
    }

    return count;
  }

}
