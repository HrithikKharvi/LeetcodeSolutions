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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode currentNode = head;
        if(list1 == null || list2 == null)return head;
        ListNode n1 = null;
        ListNode n2 = null;
        int count = 0;
        ListNode prevNode = null;
        while(currentNode != null){

          if(count == a){
            n1 = prevNode;
          }
          if(count == b+1){
            n2 = currentNode;
          }

          prevNode = currentNode;
          currentNode = currentNode.next;
          count++;
        }

        if(n1 != null)n1.next = list2;
          ListNode curr = list2;
          ListNode prev = null;
          while(curr != null){
            prev = curr;
            curr = curr.next;
          }

          if(prev != null)prev.next = n2;

        return head;

    }
}
