class Solution {
    public int diagonalSum(int[][] mat) {
        int start =0;
        int end = mat[0].length-1;

        int sum = 0;

        for(int i=0; i< mat.length; i++){
          for(int j=0; j<mat[0].length; j++){
            if(j == start+i || j == end - i){
              sum += mat[i][j];
            }
          }
        }

        return sum;
    }
}
