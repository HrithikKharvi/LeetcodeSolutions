class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getList(result, n, n, "");
        return result;
    }

    public void getList(List<String> result, int openB, int closeB, String currentString){
      System.out.println(openB + "->" + closeB);
      if(openB == 0 && closeB == 0){
        result.add(currentString);
        return;
      }

      if(openB < 0 || closeB < 0)return;

      if(openB > closeB)return;
      getList(result, openB-1, closeB, currentString + "(");
      getList(result, openB, closeB - 1, currentString + ")");
    }

}
