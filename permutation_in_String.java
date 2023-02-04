class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] map = new int[26];
        for(int i=0; i< s1.length(); i++)map[s1.charAt(i) - 'a']++;
        int i=0;
        int j=0;
        int totalCount = s1.length();
        while(j<s2.length()){
          if(map[s2.charAt(j++) - 'a']-- > 0)totalCount--;
          if(totalCount == 0)return true;
          if(j - i == s1.length() && map[s2.charAt(i++)-'a']++ >= 0)totalCount++;
        }

        return false;
    }
}
