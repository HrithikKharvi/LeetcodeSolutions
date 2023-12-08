class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsArray = formCharArray(chars);
        int count = 0;

        for(String word : words){
          int[] wordArray = formCharArray(word);
          boolean isValid = true;

          for(char ch : word.toCharArray()){
            if(wordArray[ch - 'a'] <= charsArray[ch - 'a']){
              continue;
            }

            isValid = false;
            break;
          }

          if(isValid)count += word.length();
        }

        return count;

    }

    //form char array

    public int[] formCharArray(String word){
      int[] list = new int[26];

      for(char ch : word.toCharArray()){
        list[ch - 'a']++;
      }

      return list;
    }
}
