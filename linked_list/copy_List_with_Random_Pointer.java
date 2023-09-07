/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      Map<Node, Node> map = new HashMap<>();
      Node newHead = copyNextNode(head, 0, map);

      Node currentNode = newHead;

      while(currentNode != null){
        if(head.random != null){
          Node randomNode = map.get(head.random);

          currentNode.random = randomNode;
        }

        currentNode = currentNode.next;

        head = head.next;
      }

      return newHead;
    }

    public Node copyNextNode(Node root, int counter, Map<Node, Node> map){
      if(root == null){
        return root;
      }

      Node newNode = new Node(root.val);
      map.put(root, newNode);

      newNode.next = copyNextNode(root.next, counter+1, map);

      return newNode;

    }

}
