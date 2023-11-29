class Solution {
    public String makeSmallestPalindrome(String s) {
        //take two pointer
        //check if values at both pointer are equal
        //if right pointer value is smaller than left pointer value,
        //then change left pointer value to right pointer value
        //else change right pointer value to left pointer value

      int i = 0;
      int j = s.length() - 1;
      char[] strs = s.toCharArray();

      while(i <= j){
        if(strs[i] > strs[j]){
          strs[i] = strs[j];
        }else if(strs[i] < strs[j]){
          strs[j] = strs[i];
        }
        i++;
        j--;
      }

      return new String(strs);

    }
}
