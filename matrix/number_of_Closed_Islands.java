class Solution {
    public int closedIsland(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int[][] visited = new int[m][n];

      for(int i=0; i< m; i++){
        for(int j=0; j<n; j++){
          if(i == 0 || i == m-1 || j == 0 || j == n-1){
            if(grid[i][j] == 0)dfs(i, j, grid, visited);
            visited[i][j] = 1;

          }
        }
      }

      int count = 0;
      for(int i=1; i< m-1; i++){
        for(int j=1; j< n-1; j++){
          if(grid[i][j] == 0 && visited[i][j] != 1){
            dfs(i, j, grid, visited);
            count++;
          }
        }
      }

      return count;
    }


    public void dfs(int i, int j, int[][] grid, int[][] visited){
      if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)return;
      if(visited[i][j] == 1 || grid[i][j] == 1)return;
      visited[i][j] = 1;
      dfs(i-1, j, grid, visited);
      dfs(i, j+1, grid, visited);
      dfs(i+1, j, grid, visited);
      dfs(i, j-1, grid, visited);

    }

}
