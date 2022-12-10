class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
     for(int i=0; i<n; i++){
       graph.add(new ArrayList<Integer>());
     }

      for(int i=0; i< edges.length; i++){
        int[] currentList = edges[i];
        graph.get(currentList[1]).add(currentList[0]);
        graph.get(currentList[0]).add(currentList[1]);
      }

      int[] visited = new int[n];

      ArrayList<Integer> queue = new ArrayList<>();
      queue.add(source);
      boolean isValid = false;

      while(queue.size() > 0){
        int currentElement = queue.remove(0);
        visited[currentElement] = 1;

        ArrayList<Integer> currentList = graph.get(currentElement);
        if(currentElement == destination){
          isValid = true;
          break;
        }
        for(int i=0; i<currentList.size();i++){
          if(visited[currentList.get(i)] != 1)queue.add(currentList.get(i));
        }

      }

      return isValid;
    }
}
