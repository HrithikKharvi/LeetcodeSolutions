class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        System.out.println(m+"here"+n);
        Set<String> set = new HashSet<>();

        for(int i=0; i< m; i++){
          for(int j=0; j<n; j++){
            if(grid[i][j] == 1)set.add(i + ":" + j);
          }
        }

        for(String str : set){
          String[] val = str.split(":");
          int i = Integer.parseInt(val[0]);
          int j = Integer.parseInt(val[1]);
          if(visited[i][j] != 1)
          max = Math.max(max, findMax(grid, i, j, visited));
        }

        return max;
    }

    public int findMax(int[][] grid, int i, int j, int[][] visited){

      if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 1)return 0;
      if(grid[i][j] == 0){
        return 0;
      }

      visited[i][j] = 1;

      int max = 0;

      max += findMax(grid, i-1, j, visited);
      max += findMax(grid, i, j+1, visited);
      max += findMax(grid, i+1, j, visited);
      max += findMax(grid, i, j-1, visited);

      return max + 1;
    }

}
