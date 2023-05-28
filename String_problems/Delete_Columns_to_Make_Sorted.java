class Solution {
    public int minDeletionSize(String[] strs) {
      int count = 0;

      for(int i=0; i<strs[0].length(); i++){
        int prev = 0;
        for(String str : strs){
          int charValue = str.charAt(i);
          if(charValue < prev){
            count++;
            break;
          }
          prev = charValue;
        }
      }
      return count;
    }
}
