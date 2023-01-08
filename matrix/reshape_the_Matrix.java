class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        return reshape(mat, r, c);
    }

    public int[][] reshape(int[][] mat, int r, int c){
      int actRow = r;
      int actCol = c;

      if(actCol*actRow != (mat.length * mat[0].length))return mat;
      System.out.println("here");
      int resultI = 0;
      int resultJ = 0;
      int[][] result = new int[actRow][actCol];
        System.out.println(result.length + ":" + result[0].length);
      
      for(int i =0; i< actRow; i++){
        for(int j=0; j< actCol; j++){

          if(resultJ == mat[0].length){
            resultJ = 0;
            resultI++;
          }
        System.out.println(resultI + "L" + resultJ);
          int ele = mat[resultI][resultJ];
          result[i][j] = ele;
          resultJ++;
        }
      }

      return result;
    }
}
