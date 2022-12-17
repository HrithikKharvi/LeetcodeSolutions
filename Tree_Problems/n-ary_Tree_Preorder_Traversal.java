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
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        preorderDFS(root, arr);
        return arr;
    }

    public void preorderDFS(Node root, ArrayList<Integer> arr){
      if(root == null)return;

      List<Node> children = root.children;
      arr.add(root.val);

      for(int i=0; i< children.size(); i++){
        preorderDFS(children.get(i), arr);
      }

    }

}
