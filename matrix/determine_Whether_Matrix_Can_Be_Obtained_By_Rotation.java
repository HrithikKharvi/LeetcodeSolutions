class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0; i< 4; i++){
          if(isValid(mat, target))return true;
        }
        
        return false;
    }
    public boolean isValid(int[][] mat, int[][] target){
      boolean isValid = true;
      int m = mat.length;
      int[][] newArray = new int[m][m];

      for(int i=0; i< m; i++){
        for(int j=0; j<m; j++){
          newArray[i][j] = mat[i][j];
        }
      }

        int n = mat.length-1;
      for(int i=0; i<mat.length; i++){
        int targetCol = n - i;

        for(int j=0; j< mat.length; j++){
          int targetRow = j;
          System.out.println(targetRow + "L" + targetCol);
          mat[targetRow][targetCol] = newArray[i][j];
          if(mat[targetRow][targetCol] != target[targetRow][targetCol])isValid = false;
        }
      }

      return isValid;
    }
}
