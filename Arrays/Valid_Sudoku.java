class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(!validateRowCol(board))return false;
        if(!checkValid(board, 0,0)) return false;
        if(!checkValid(board, 0,3))return false;
        if(!checkValid(board, 0,6))return false;
        if(!checkValid(board, 3,0))return false;
        if(!checkValid(board, 3,3))return false;
        if(!checkValid(board, 3,6))return false;
        if(!checkValid(board, 6,0))return false;
        if(!checkValid(board, 6,3))return false;
        if(!checkValid(board, 6,6))return false;

        return true;
    }

    public boolean validateRowCol(char[][] board){
      Set<Integer>[] row = new HashSet[9];
      Set<Integer>[] col = new HashSet[9];
      for(int i=0; i<9; i++){
        row[i] = new HashSet<>();
        col[i] = new HashSet<>();
      }

      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[0].length; j++){
          if(board[i][j] == 46)continue;
          int val =  board[i][j] - 49;
          if(row[i].contains(val) || col[j].contains(val))return false;
          row[i].add(val);
          col[j].add(val);
        }
      }

      return true;
    }

    public boolean checkValid(char[][] board,int i, int j){
      int[] arr = new int[10];

      for(int row=i; row < i+3; row++){
        for(int col=j; col<j+3; col++){
          if(board[row][col] == 46)continue;
          int val = board[row][col] -49;
          if(arr[val] == 1)return false;
          arr[val] = 1;
        }
      }

      return true;
    }

}
