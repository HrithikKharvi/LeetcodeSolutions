class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] charArray = new int[26];

        int count = formArray(charArray, licensePlate);
        String completedWord = "";
        

        for(int i=0; i< words.length; i++){
          String word = words[i];
          boolean isValid = check(charArray, count, word);

          if(isValid){
            if(completedWord.length() == 0){
              completedWord = word;
            }else{
              completedWord = completedWord.length() <= word.length() ? completedWord : word;
            }
          }
        }

        return completedWord;
    }

    public boolean check(int[] arr, int count, String word){
      int[] copy = new int[26];

      System.arraycopy(arr, 0, copy, 0, 26);

      for(int i=0; i< word.length(); i++){
        char ch = word.charAt(i);
        // copy[ch - 'a']--;

        if(copy[ch - 'a'] > 0){
          count--;
          copy[ch - 'a']--;
        }
      }

      if(count == 0)return true;

      return false;
    }

  public int formArray(int[] arr, String word){
    word = word.toLowerCase();
    int count = 0;

    for(int i=0; i< word.length(); i++){
      char ch = word.charAt(i);

      if(ch >= 'a' && ch <= 'z'){
        arr[ch - 'a']++;
        count++;
      }
    }

    return count;
  }

}
