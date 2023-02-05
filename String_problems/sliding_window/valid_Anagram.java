class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arrCount = convertIntoArray(s);
        if(s.length() > t.length() || s.length() < t.length())return false;

        int required = s.length();

        for(int i=0; i< t.length(); i++){
          char ch = t.charAt(i);
          if(arrCount[ch - 'a']-- > 0)required--;
        }

        return required == 0;

    }

    public int[] convertIntoArray(String s){
      int[] arr = new int[26];

      for(int i=0; i< s.length(); i++){
        char ch = s.charAt(i);
        arr[ch - 'a']++;
      }

      return arr;
    }
}
