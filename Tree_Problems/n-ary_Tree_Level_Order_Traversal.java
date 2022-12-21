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
    public List<List<Integer>> levelOrder(Node root) {
        Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        dfs(root, 0, map);
        System.out.println(map);
        List<List<Integer>> arr = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> item : map.entrySet()){
          arr.add(item.getValue());
        }
        return arr;
    }

    public void dfs(Node root, int level, Map<Integer, ArrayList<Integer>> map){
      if(root == null)return;
      if(!map.containsKey(level)){
        map.put(level, new ArrayList<Integer>());
      }
        map.get(level).add(root.val);
        List<Node> children = root.children;

        for(Node node : children){
          dfs(node, level+1, map);
        }
    }

}
