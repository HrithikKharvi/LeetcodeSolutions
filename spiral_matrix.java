class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] visited = new int[matrix.length][matrix[0].length];

        recurse(matrix, "RIGHT",visited, 0, 0, result);

        return result;
    }

    //go right, then bottom, then left, and then top

    public void recurse(int[][] mat, String side, int[][] visited, int i, int j, List<Integer> result){

      if(i< 0 || j < 0 || i >= mat.length || j >= mat[0].length)return;
      if(visited[i][j] == 1)return;

      result.add(mat[i][j]);
      visited[i][j] = 1;
      if(side.equals("RIGHT"))
      recurse(mat, side, visited, i, j+1, result);
      else if(side.equals("DOWN"))
      recurse(mat, side, visited, i+1, j, result);
      else if(side.equals("LEFT"))
      recurse(mat, side, visited, i, j-1, result);
      else if(side.equals("UP"))
      recurse(mat, side, visited, i-1, j, result);


      if(!side.equals("RIGHT"))
      recurse(mat, "RIGHT", visited, i, j+1, result);
      if(!side.equals("DOWN"))
      recurse(mat, "DOWN", visited, i+1, j, result);
      if(!side.equals("LEFT"))
      recurse(mat, "LEFT", visited, i, j-1, result);
      if(!side.equals("UP"))
      recurse(mat, "UP", visited, i-1, j, result);

    }

}
