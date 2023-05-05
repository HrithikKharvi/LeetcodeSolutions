class Solution {
    public int maxVowels(String s, int k) {
      return findMaxCount(s, k);
    }

    public int findMaxCount(String s, int k){
      int start = 0;
      int end = 0;
      int max = 0;
      int count = 0;
      HashMap<Character, Boolean> map = new HashMap<>();
      
      String vowels = "aeiouAEIOU";

      for(int i=0; i< vowels.length(); i++){
        map.put(vowels.charAt(i), true);
      }

      while(end < s.length()){
        if(map.containsKey(s.charAt(end)))count++;

        if(end - start + 1 == k){
          if(count > max)max = count;
          if(map.containsKey(s.charAt(start)))count--;
          start++;
        }

        end++;
      }

      return max;
    }

}
