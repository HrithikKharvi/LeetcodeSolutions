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

class NewNodeList{
  public int max = 0;
  public ListNode more = null;
}

class Solution {
    public ListNode removeNodes(ListNode head) {
        return remove(head).more;
    }

    public NewNodeList remove(ListNode head){
      if(head == null){
        return new NewNodeList();
      }

      NewNodeList res = remove(head.next);

      if(head.val >= res.max){
        head.next = res.more;
        res.max =  head.val;
        res.more = head;
      }

      return res;

    }

}
