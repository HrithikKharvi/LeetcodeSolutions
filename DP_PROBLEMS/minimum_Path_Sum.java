class Solution {
    public int minPathSum(int[][] grid) {
        Map<String, Integer> memo = new HashMap<>();
        return findPathSum(grid, 0, 0, memo);
    }

    public int findPathSum(int[][] grid, int i, int j, Map<String, Integer> memo){
      if(memo.containsKey(i+":"+j))return memo.get(i+":"+j);
      if(i == grid.length-1 && j == grid[0].length-1)return grid[i][j];
      if(i >= grid.length || j >= grid[0].length)return -1;
      int right = findPathSum(grid,i, j+1, memo);
      int down = findPathSum(grid, i+1, j, memo);
      
      int sum = 0;
      if(right == -1 )sum = down;
      if(down == -1) sum = right;
      if(right != -1 && down != -1) sum = Math.min(right, down);

      memo.put(i+":"+j, sum + grid[i][j]);
      // System.out.println(memo.get(i));
      return sum + grid[i][j];

    }

}
