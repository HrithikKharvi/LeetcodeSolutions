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
    public ListNode oddEvenList(ListNode head) {
      if(head == null || head.next == null)return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p2Head = p2;
        ListNode p1Head = p1;

        while(p2 != null && p2.next != null){
          p1.next = p1.next.next;
          p1 = p1.next;
          p2.next = p2.next.next;
          p2 = p2.next;
        }

        p1.next = p2Head;
        return p1Head;
    }
}
