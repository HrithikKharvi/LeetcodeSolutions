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

public class CustomNode{
  public int count;
  public ListNode node;

  public CustomNode(int count){
    this.count = count;
  }

}

class Solution {
    public ListNode swapPairs(ListNode head) {
      int length = length(head);
        return swap(head, length).node;
    }

    public int length(ListNode head){
      int count = 0;

      while(head != null){
        count++;
        head = head.next;
      }

      return count;
    }

    public CustomNode swap(ListNode head, int length){
      if(head == null){
        return new CustomNode(0);
      }

      CustomNode res = swap(head.next, length);

      if(length % 2 == 1 && res.count == 0){
        res.count += 2;
        res.node = head;
        return res;
      }

      if(res.count % 2 == 1){
        ListNode next = res.node.next;
        head.next = next;
        res.node.next = head;
      }else{
        head.next = res.node;
        res.node = head;
      }

      res.count += 1;
      return res;

    }

}
