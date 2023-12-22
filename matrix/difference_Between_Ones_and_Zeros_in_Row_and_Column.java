class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int[][] result = new int[m][n];

      int[] onesRow = new int[m];
      int[] onesCol = new int[n];
      int[] zeroRow = new int[m];
      int[] zeroCol = new int[n];

      for(int i=0; i<m; i++){
        int oneCount = 0;
        for(int j=0; j<n; j++){
          if(grid[i][j] == 1){
            onesRow[i]++;
            onesCol[j]++;
          }
          else{
            zeroRow[i]++;
            zeroCol[j]++;
          }
        }
      }

      for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
          int sum = onesRow[i] + onesCol[j] - zeroRow[i] - zeroCol[j];

          result[i][j] = sum;
        }
      }

      return result;


    }
}
