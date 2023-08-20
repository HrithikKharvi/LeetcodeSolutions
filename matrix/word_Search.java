class Solution {
    public boolean exist(char[][] board, String word) {
        List<Pair<Integer, Integer>> queue = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;

        char startChar = word.charAt(0);
        for(int i=0; i< n; i++){
          for(int j=0; j<m; j++){
            if(board[i][j] == startChar)queue.add(new Pair(i, j));
          }
        }


        while(queue.size() > 0){
          Pair<Integer, Integer> pair = queue.remove(0);
          int i = pair.getKey();
          int j = pair.getValue();

          int[][] visited = new int[n][m];
          if(checkMatrix(board, i, j, 0, word, visited))return true;

        }

        return false;
    }

    public boolean checkMatrix(char[][] board, int i, int j, int wordIndex, String word, int[][] visited){
      if(wordIndex >= word.length())return true;

      if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)return false;

      if(visited[i][j] != 0)return false;
      if(word.charAt(wordIndex) != board[i][j])return false;

      visited[i][j] = 1;

      if(checkMatrix(board, i-1, j, wordIndex+1, word, visited))return true;
      if(checkMatrix(board, i, j+1, wordIndex+1, word, visited))return true;
      if(checkMatrix(board, i+1, j, wordIndex+1, word, visited))return true;
      if(checkMatrix(board, i, j-1, wordIndex+1, word, visited))return true;

      visited[i][j] = 0;
      return false;
    }
}
