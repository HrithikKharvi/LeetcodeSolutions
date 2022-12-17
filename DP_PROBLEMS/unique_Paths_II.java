class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        return findUnique(obstacleGrid, 0, 0, obstacleGrid.length-1, obstacleGrid[0].length-1, map);
    }

    public int findUnique(int[][] grid, int i, int j, int m, int n, Map<String, Integer> map){
      if(map.containsKey(i+":"+j))return map.get(i+":"+j);
      if(i > m || j > n)return 0;
      if(i == m && j == n && grid[m][n] != 1)return 1;
      if(grid[i][j] == 1)return 0;

      int left = findUnique(grid, i, j+1, m, n, map);
      int right = findUnique(grid, i+1, j, m, n, map);

      map.put(i+":"+j, left+right);
      return left + right;

    }

}
