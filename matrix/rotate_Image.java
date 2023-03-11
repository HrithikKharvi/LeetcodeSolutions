/*
*THIS ALGORITHM TAKES O(N^2) TIME COMPLEXITY
*THIS APPROCH TAKES O(1) SPACE COMPLEXITY
*/

class Solution {
    public void rotate(int[][] matrix) {
      if(matrix.length == 0 || matrix.length != matrix[0].length)return;

      for(int layer=0; layer < matrix.length/2; layer++){
        int first = layer;
        int end = matrix.length - 1 - layer;

        for(int i=first; i<end; i++){
          int offset = i - first;

          int top = matrix[first][i];

          matrix[first][i] = matrix[end - offset][first];
          matrix[end-offset][first] = matrix[end][end-offset];
          matrix[end][end-offset] = matrix[i][end];
          matrix[i][end] = top;
        }
      }

    }
}
