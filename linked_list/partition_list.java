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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = null;
        ListNode p1Head = null;

        ListNode currentNode = head;
        ListNode prev = null;

        while(currentNode != null){
          if(currentNode.val < x){
            ListNode deletingNode = currentNode;

            if(prev == null){
              head = currentNode.next;
            }else{
              prev.next = currentNode.next;
            }

            if(p1 == null){
              p1 = deletingNode;
              p1Head = p1;
            }else{
              p1.next = deletingNode;
              p1 = p1.next;
            }
          }else{
          prev = currentNode;
          }
          currentNode = currentNode.next;
        }

        if(p1Head != null){
          p1.next = head;
          head = p1Head;
        }

        return head;
    }
}
