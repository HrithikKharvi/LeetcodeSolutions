class Solution {
    public void rotate(int[][] matrix) {
      int wall = matrix[0].length - 1;
      int[][] result = new int[matrix.length][matrix[0].length];

      for(int i=0; i< matrix.length; i++){
        for(int j=0; j< matrix[0].length; j++){
          result[i][j] = matrix[i][j];
        }
      }

        for(int i=0; i< matrix.length; i++){
          int targetCol = wall - i;
          for(int j=0; j< matrix[0].length; j++){
            int targetRow = j;

            matrix[targetRow][targetCol] = result[i][j];
          }
        }
    }
}
