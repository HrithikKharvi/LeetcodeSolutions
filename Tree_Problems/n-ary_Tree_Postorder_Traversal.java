/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
     ArrayList<Integer> arr = new ArrayList<>();
     postorderDFS(root, arr);
     return arr;
    }

    public void postorderDFS(Node root, ArrayList<Integer> arr){
      if(root == null)return;

      List<Node> children = root.children;

      for(Node node : children){
        postorderDFS(node, arr);
      }

      arr.add(root.val);

    }

}
