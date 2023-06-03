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
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length == 0)return null;
      if(lists.length == 1) return lists[0];
        ListNode head = lists[0];
        for(int i=1; i< lists.length; i++){
          head = mergeLists(head, lists[i]);
        }

        return head;
    }

    public ListNode mergeLists(ListNode headNode, ListNode nextList){

      ListNode head = null;
      ListNode currentNode = null;

      ListNode currentLeftNode = headNode;
      ListNode currentRightNode = nextList;

      while(currentLeftNode != null && currentRightNode != null){
        if(currentLeftNode.val < currentRightNode.val){
          if(head == null){
            head = currentLeftNode;
            currentNode = head;
          }else{
            currentNode.next = currentLeftNode;
            currentNode = currentNode.next;
          }

          currentLeftNode = currentLeftNode.next;
        }else{
          if(head == null){
            head = currentRightNode;
            currentNode = head;
          }else{
            currentNode.next = currentRightNode;
            currentNode = currentNode.next;
          }
          currentRightNode = currentRightNode.next;
        }
      }

      if(currentLeftNode != null){
        if(head == null){
            head = currentLeftNode;
            currentNode = head;
          }else{
            currentNode.next = currentLeftNode;
            currentNode = currentNode.next;
          }

          currentLeftNode = currentLeftNode.next;
      }

      if(currentRightNode != null){
        if(head == null){
            head = currentRightNode;
            currentNode = head;
          }else{
            currentNode.next = currentRightNode;
            currentNode = currentNode.next;
          }
          currentRightNode = currentRightNode.next;
      }

      return head;

    }
}
