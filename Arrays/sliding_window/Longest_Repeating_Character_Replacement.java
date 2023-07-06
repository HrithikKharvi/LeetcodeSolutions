class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        formCharSet(set, s);

        for(Character c : set){
          int i = 0;
          int j = 0;
          int count = k;

          while(j < s.length()){
            if(s.charAt(j) != c && count == 0){
              int currentCount = j-i;
              max = Math.max(max, currentCount);
              if(c != s.charAt(i))count++;
              i++;
            }else{
              if(c != s.charAt(j))count--;
              j++;
            }
          }
          max = Math.max(j-i, max);
        }

        return max;
    }

    public void formCharSet(Set<Character> set, String s){
      for(int i=0; i<s.length(); i++){
        set.add(s.charAt(i));
      }
    }
}
