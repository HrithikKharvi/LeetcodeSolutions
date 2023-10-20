class Solution {
    public int countGoodSubstrings(String s) {
      if(s.length() < 3)return 0;
        char p1 = s.charAt(0);
        char p2 = s.charAt(1);
        int p3 = 2;
        int count = 0;

        while(p3 < s.length()){
          char c3 = s.charAt(p3);

          if(p1 != p2 && p2 != c3 && p1 != c3)count++;


          p1 = p2;
          p2 = c3;
          p3++;
        }

        return count;
    }
}   
