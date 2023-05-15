/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
      ListNode prevNode = null;
      while(node.next != null){
        node.val = node.next.val;
        prevNode = node;
        node = node.next;
      }
      prevNode.next = null;

        // delete(node);
    }

    public ListNode delete(ListNode node){
      if(node.next == null) return null;
      node.val = node.next.val;
      node.next = delete(node.next);
      return node;
    }
}
