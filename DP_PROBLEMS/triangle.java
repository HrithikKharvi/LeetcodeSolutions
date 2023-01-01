class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[][] memo = new int[triangle.size()][triangle.get(n-1).size()];
      for(int[] i : memo)Arrays.fill(i, -1);
        return minimumPath(triangle, 0, 0, memo);
    }

    public int minimumPath(List<List<Integer>> triangle, int index, int col, int[][] memo){
      if(index == triangle.size()-1)return triangle.get(index).get(col);
      if(memo[index][col] != -1) return memo[index][col];

      int bottom = triangle.get(index).get(col) + minimumPath(triangle, index+1, col, memo);
      int diagonal = triangle.get(index).get(col) + minimumPath(triangle, index+1, col+1, memo);

      memo[index][col] = Math.min(bottom, diagonal);
      return Math.min(bottom, diagonal);
    }
}
