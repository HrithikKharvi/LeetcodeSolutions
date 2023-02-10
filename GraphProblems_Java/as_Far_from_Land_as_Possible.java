class Solution {
    public int maxDistance(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int[][] visited = new int[m][n];

      ArrayList<String> arr = new ArrayList<>();

      int count =  0;
      for(int i=0; i< m; i++){
        for(int j=0; j<n; j++){
          if(grid[i][j] == 1){
            visited[i][j] = -1;
            count++;
            arr.add(i + ":" + j + ":" + 0);
          }
        }
      }

      if(count == 0 || (m*n) == count)return -1;
      int max = -1;
      while(arr.size() > 0){
        String[] val = arr.remove(0).split(":");
        int i = Integer.parseInt(val[0]);
        int j = Integer.parseInt(val[1]);
        int distance = Integer.parseInt(val[2]);
        
        visited[i][j] = distance;
        if(i-1 >= 0 && visited[i-1][j] == 0 && grid[i-1][j] == 0){
            arr.add((i-1) + ":" + j + ":" + (distance + 1));
            visited[i-1][j] = distance+1;
        }
        if(j+1 < n && visited[i][j+1] == 0 && grid[i][j+1] == 0){
            arr.add((i) + ":" + (j+1) + ":" + (distance + 1));
            visited[i][j+1] = distance+1; 
        }

        if(i+1 < m && visited[i+1][j] == 0 && grid[i+1][j] == 0){
            arr.add((i+1) + ":" + j + ":" + (distance + 1));
            visited[i+1][j] = distance+1;
           
        }
        if(j-1 >= 0 && visited[i][j-1] == 0 && grid[i][j-1] == 0){
            arr.add((i) + ":" + (j-1) + ":" + (distance + 1));
            visited[i][j-1] = distance+1;
        }
      }

      for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
          max = Math.max(max, visited[i][j]);
        }
      }
      return max;
    }
}
