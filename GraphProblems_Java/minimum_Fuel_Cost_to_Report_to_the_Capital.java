class Solution {

  long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

      for(int i=0; i<=roads.length; i++){
        graph.add(new ArrayList<>());
      }

      for(int i=0; i< roads.length; i++){
        int[] road = roads[i];
        graph.get(road[0]).add(road[1]);
        graph.get(road[1]).add(road[0]);
      }

      int[] visited = new int[roads.length+1];
      dfs(graph, 0, seats, visited);

      return ans;

    }

    public long dfs(ArrayList<ArrayList<Integer>> graph, int node, int seats, int[] visited){

      visited[node] = 1;

      ArrayList<Integer> neighbour = graph.get(node);

      long count = 1;
      for(int nei : neighbour){
        if(visited[nei] != 1)count += dfs(graph, nei, seats, visited);
      }

      long cars = count / seats;

      if(count % seats != 0)cars++;

      if(node != 0) ans += cars;

      return count;

    }

}
