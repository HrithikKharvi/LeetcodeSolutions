class Solution {
    public int uniquePaths(int m, int n) {
      Map<String, Integer> memo = new HashMap<String, Integer>();
        return findUnique(m-1, n-1, 0, 0, memo);
    }

    public int findUnique(int tm, int tn, int i, int j, Map<String, Integer> memo){
      if(memo.containsKey(i+":"+j))return memo.get(i+":"+j);
      if(i == tm && j == tn)return 1;
      if(i > tm || j > tn)return 0;

      int left = findUnique(tm,tn, i, j+1, memo);
      int right = findUnique(tm, tn, i+1, j, memo);
      memo.put(i+":"+j, left+right);
    return left + right;
    }

}
