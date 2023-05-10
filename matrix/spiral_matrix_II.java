class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        recurse(arr, "RIGHT", 0, 0, 1);

        return arr;
    }

    public void recurse(int[][] mat, String side, int i, int j, int n){

      if(i< 0 || j < 0 || i >= mat.length || j >= mat[0].length)return;
      if(mat[i][j] != 0)return;

      mat[i][j] = n;


      if(side.equals("RIGHT"))
      recurse(mat, side, i, j+1, n+1);
      else if(side.equals("DOWN"))
      recurse(mat, side, i+1, j, n+1);
      else if(side.equals("LEFT"))
      recurse(mat, side, i, j-1, n+1);
      else if(side.equals("UP"))
      recurse(mat, side, i-1, j, n+1);


      if(!side.equals("RIGHT"))
      recurse(mat, "RIGHT", i, j+1, n+1);
      if(!side.equals("DOWN"))
      recurse(mat, "DOWN", i+1, j, n+1);
      if(!side.equals("LEFT"))
      recurse(mat, "LEFT", i, j-1, n+1);
      if(!side.equals("UP"))
      recurse(mat, "UP", i-1, j, n+1);

    }

}
