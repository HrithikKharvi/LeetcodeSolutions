class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

      List<List<Integer>> list = new ArrayList<>();

      ArrayList<Integer> currentList = new ArrayList<>();
      currentList.add(0);
      dfs(graph, 0, currentList, list);

      return list;

    }

    public void dfs(int[][] graph, int currentNode, ArrayList<Integer> currentList, List<List<Integer>> finalList){
      if(currentNode == graph.length - 1){
        ArrayList<Integer> newList = new ArrayList<>();
        newList = (ArrayList<Integer>)currentList.clone();
        finalList.add(newList);
        return;
      }

      int[] adjs = graph[currentNode];

      for(Integer ad : adjs){
        currentList.add(ad);
        dfs(graph, ad, currentList, finalList);
        currentList.remove(currentList.size()-1);
      }

    }

}
