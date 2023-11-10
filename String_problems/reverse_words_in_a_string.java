class Solution {
    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        char[] ans = new char[charArr.length];
        int i = charArr.length-1;

        int ind = 0;

        while(i >= 0 && charArr[i] == ' ')i--;

        while(i >= 0){
          int j = i;

          while(i >= 0 && charArr[i] != ' ')i--;

          if(ind > 0)ans[ind++] = ' ';
          for(int k=i+1; k<=j; k++)ans[ind++] = charArr[k];

          while(i >= 0 && charArr[i] == ' ')i--;
        }

        return new String(ans, 0, ind);

    }
}
