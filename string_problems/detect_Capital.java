//Using Regular expression

class Solution {
    public boolean detectCapitalUse(String word) {
      if(word.equals(""))return false;
        if(word.matches("^[A-Z]*$") || (word.substring(0,1).matches("^[A-Z]$") && word.substring(1).matches("^[a-z]*$")) || word.matches("^[a-z]*$"))return true;
        return false;
    }
}
