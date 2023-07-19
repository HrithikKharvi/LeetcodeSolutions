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

class TempClass{
  public int  rem = 0;
  public ListNode node = null;
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int lengthOne = findListLength(l1);
        int lengthTwo = findListLength(l2);

        ListNode first = lengthOne > lengthTwo ? l1 : l2;
        ListNode second = lengthOne <= lengthTwo ? l1 : l2;

        TempClass resultedTemp = addList(first, second, 0, Math.abs(lengthOne-lengthTwo));

        if(resultedTemp.rem != 0){
          ListNode newHead = new ListNode(resultedTemp.rem);
          newHead.next = resultedTemp.node;
          resultedTemp.node = newHead;
        }

        return resultedTemp.node;
    }

    public int findListLength(ListNode l){
      int count = 0;

      while(l !=  null && l.next != null){
        l = l.next;
        count++;
      }

      return count;
    }

    public TempClass addList(ListNode first, ListNode second, int count, int rem){
      if(first == null )return new TempClass();

      if(count < rem){
        TempClass result = addList(first.next, second, count+1, rem);
        addListValue(first, null, result);
        return result;
      }else{
        TempClass result = addList(first.next, second.next, count+1, rem);
        addListValue(first, second, result);

        return result;
      }
    }

    public TempClass addListValue(ListNode first, ListNode second, TempClass result){
      int sum = first.val + result.rem;

      if(second != null){
        sum += second.val;
      }

      ListNode newList = new ListNode(sum%10);
      result.rem = sum / 10;
      newList.next = result.node;
      result.node = newList;

      return result;
    }

}
