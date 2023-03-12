class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())return false;
        return checkSubstring(s+s, goal);
    }

    public boolean checkSubstring(String s1, String sub){

      System.out.println(sub);
      int start = 0;
      int diff = sub.length();

      while(start+diff <= s1.length()){
        String s1Sub = s1.substring(start, start+diff);
        System.out.println(s1Sub);
        if(s1Sub.equals(sub))return true;
        start++;
      }

      return false;
    }

}
