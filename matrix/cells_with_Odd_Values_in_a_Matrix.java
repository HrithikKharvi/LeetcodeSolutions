class Solution {
    public int oddCells(int m, int n, int[][] indices) {
      int[][] result = new int[m][n];
      for(int i=0; i< m; i++){
        Arrays.fill(result[i], 0);
      }
        for(int i =0; i< indices.length; i++){
          int iPos = indices[i][0];
          int jPos = indices[i][1];

          performActionI(iPos, result);
          performActionJ(jPos, result);
        }

        int count = 0;
        for(int i=0; i< m; i++){
          for(int j=0; j< n; j++){
            if(result[i][j]%2 == 1)count++;
          }
        }

        return count;

    }

    public void performActionI(int i, int[][] result){
      for(int j=0; j< result[0].length; j++){
        result[i][j] = result[i][j] + 1;
      }
    }

    public void performActionJ(int j, int[][] result){
      for(int i=0; i< result.length; i++){
        result[i][j] = result[i][j] + 1;
      }
    }

}
