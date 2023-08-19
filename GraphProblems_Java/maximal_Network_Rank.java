class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        
        int[][] mat = new int[n][n];
        List<Integer> graph = new ArrayList<>();

        for(int i=0; i<n; i++)graph.add(0);

        for(int i=0; i<roads.length; i++){
          int[] road = roads[i];
          int start = road[0];
          int end = road[1];
          mat[start][end] = 1;
          mat[end][start] = 1;
          graph.set(start, graph.get(start) + 1);
          graph.set(end, graph.get(end)+1);
        }

        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            if(i==j)continue;
            int isPresent = 0;
            if(mat[i][j] != 0)isPresent = 1;
            int startSize = graph.get(i);
            int endSize = graph.get(j);


            int tot = startSize + endSize - isPresent;
            max = Math.max(max,tot);
          }
        }

        return max;
    }
}
