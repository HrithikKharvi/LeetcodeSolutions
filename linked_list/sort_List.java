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
    public ListNode sortList(ListNode head) {
      ListNode currentNode = head;
      ArrayList<Integer> list = new ArrayList<>();

      while(currentNode != null){
        list.add(currentNode.val);
        currentNode = currentNode.next;
      }

      int[] arr = new int[list.size()];

      for(int i=0; i< arr.length; i++){
        arr[i] = list.get(i);
      }

      Arrays.sort(arr);

      currentNode = head;
      int i = 0;
      while(currentNode != null){
        currentNode.val = arr[i++];
        currentNode = currentNode.next;
      }

      return head;
    }
}
