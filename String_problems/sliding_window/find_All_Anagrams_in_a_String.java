class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      if(p.length() > s.length())return new ArrayList<>();
        int i = 0;
        int j = p.length()-1;
        List<Integer> arr = new ArrayList<>();

        while(j < s.length()){
          boolean isAn = isAnagram(s.substring(i, j+1), p);

         if(isAn){
           arr.add(i);
         }

          i++;
          j++;
        }

        return arr;
        
    }

    public boolean isAnagram(String str1, String str2){
      int[] char1 = convertIntoCharArray(str1);
      int[] char2 = convertIntoCharArray(str2);


      int required = str2.length();

      for(int i=0; i<str2.length(); i++){
        char ch = str2.charAt(i);
        int chAtChar1 = char1[ch - 'a'];
        int chAtChar2 = char2[ch - 'a'];
        if(chAtChar1 != chAtChar2)return false;
        required--;
        char1[ch - 'a']--;
        char2[ch - 'a']--;
      }

      if(required != 0)return false;
      return true;
    }

    public int[] convertIntoCharArray(String str){
      int[] arr = new int[26];
      for(int i=0; i<str.length(); i++){
        arr[str.charAt(i) - 'a']++;
      }
      return arr;
    }

}
