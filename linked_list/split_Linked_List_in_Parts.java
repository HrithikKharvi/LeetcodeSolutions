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
    public ListNode[] splitListToParts(ListNode head, int k) {
      int length = findLength(head);

      int numbersToFill = (length / k);

      int rem = length % k;

      ListNode currentNode = head;
      ListNode currentListHead = null;
      ListNode currentListTail = null;
      int count = 0;
      int index = 0;
      ListNode[] result = new ListNode[k];
      ListNode prevNode = null;

      int end = numbersToFill;
      if(rem > 0){
        end++;
        rem--;
      }
      while(currentNode != null){
        if(count == end){
          result[index++] = currentListHead;
          if(prevNode != null)prevNode.next = null;
          currentListHead = null;
          currentListTail = null;
          count = 0;

          end = numbersToFill;
          if(rem > 0){
            end++;
            rem--;
          }
        }else if(count == 0){
          prevNode = currentNode;
          currentListHead = currentNode;
          currentListTail = currentNode;
          count++;
          currentNode = currentNode.next;
        }else{
          prevNode = currentNode;
          count++;
          currentListTail.next = currentNode;
          currentListTail = currentListTail.next;
          currentNode = currentNode.next;
        }
      }

      result[index] = currentListHead;

      return result;


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
