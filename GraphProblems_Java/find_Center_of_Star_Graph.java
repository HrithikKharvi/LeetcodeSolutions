class Solution {
    public int findCenter(int[][] edges) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();

      for(int i=0; i< edges.length; i++){
        int[] arr = edges[i];
        int j = arr[0];
        int k = arr[1];
        put(map, j);
        put(map, k);
      }

      for(Integer i : map.keySet()){
        int counts = map.get(i);
        if(counts == map.size() - 1)return i;
      }

      return -1;

    }
    public void put(Map<Integer, Integer> map, int i){
      if(map.containsKey(i)){
        map.put(i, map.get(i) + 1);
      }else{
        map.put(i, 1);
      }
    }
}
