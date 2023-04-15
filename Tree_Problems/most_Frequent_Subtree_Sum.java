/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        findPathSums(root, map);
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
          int key = entry.getKey();
          int value = entry.getValue();

          if(value >= max)max = value;
        }

        System.out.println(max);
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
          int key = entry.getKey();
          int value = entry.getValue();

          if(value == max)res.add(key);
        }

        int[] resultArray = new int[res.size()];
        for(int i=0; i< resultArray.length; i++){
          resultArray[count++] = res.get(i);
        }

        return resultArray;
    }

    public int findPathSums(TreeNode root, HashMap<Integer, Integer> map){
      if(root == null)return 0;
      int result = root.val;

      result += findPathSums(root.left, map);
      result += findPathSums(root.right, map);

      if(map.containsKey(result)){
        map.put(result, map.get(result) + 1);
      }else{
        map.put(result, 1);
      }

      return result;
    }

}
