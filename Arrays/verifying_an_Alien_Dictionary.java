class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];

        for(int i=0; i< order.length(); i++){
          map[order.charAt(i) - 'a'] = i;
        }

        System.out.println(Arrays.toString(map));

        for(int i=0; i< words.length - 1; i++){
          if(compare(words[i] , words[i+1], map))return false;
        }

        return true;
    }

    public boolean compare(String word1, String word2, int[] map){
      int i =0;
      int j = 0;

      while(i < word1.length() && j < word2.length()){
        if(map[word1.charAt(i)-'a'] > map[word2.charAt(j)-'a'])return true;
        if(map[word1.charAt(i)-'a'] < map[word2.charAt(j)-'a'])return false;
        i++;
        j++;
      }

      if(word1.length() > word2.length())return true;

      return false;

    }

}
