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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();

        ListNode current = head;

        while(current != null){
          int data = current.val;
          if(map.containsKey(data)){
            map.put(data, map.get(data) + 1);
          }else{
            map.put(data, 1);
          }
          current = current.next;
        }

      current = head;
      ListNode pre = null;

      while(current != null){
        System.out.println(current.val);
        if(map.get(current.val) > 1){
          if(current == head){
            head = head.next;
            current = head;
          }else{
            pre.next = current.next;
            current = current.next;
          }
        }else{
          pre = current;
          current = current.next;
        }
      }

      return head;

    }
}
