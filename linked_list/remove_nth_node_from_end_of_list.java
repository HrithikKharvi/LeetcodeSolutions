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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode currentNode = head;
        ListNode runner = head;
        ListNode prev = null;
        int count = 0;


        while(count < k && runner != null){
          count++;
          runner =runner.next;
        }

        if(count < k && runner == null)return head;
        while(runner != null){
          runner = runner.next;
          prev = currentNode;
          currentNode = currentNode.next;
        }

        if(prev == null){
          head = head.next;
        }else{
          prev.next = currentNode.next;
        }

        return head;

    }
}
