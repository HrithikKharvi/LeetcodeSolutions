class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int[] checkedList = new int[graph.length];

      ArrayList<Integer> check = new ArrayList<>();  
      int[] visited = new int[graph.length];

      for(int i=0; i<graph.length; i++){
        if(visited[i] != 1){
          dfs(graph, visited, checkedList, i);
        }
        
        if(checkedList[i] == 1){
          check.add(i);
        }
      }

      return check;
    }

    public boolean dfs(int[][] graph, int[] visited, int[] checkList, int i){
     visited[i] = 1;
     int count = 0;
     int[] currentList = graph[i];

      if(currentList.length == 0){
        checkList[i] = 1;
        return true;
      }

      int totalSubs = currentList.length;
      for(int j=0; j<currentList.length; j++){
        int currentValue = currentList[j];
        if(visited[currentValue] == 1 && checkList[currentValue] == 1)count++;
        if(visited[currentValue] != 1){
          if(dfs(graph, visited, checkList, currentValue)){
            count++;
          }
        }
      }

      if(count == totalSubs){
        checkList[i] = 1;
        return true;
      }

      return false;
    }
}
