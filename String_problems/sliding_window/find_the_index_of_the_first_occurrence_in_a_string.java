class Solution {
    public int strStr(String haystack, String needle) {
        int index = 0;

        while(needle.length() <= (haystack.length() - index)){
          String substring = haystack.substring(index, index+needle.length());
          if(substring.equals(needle))return index;
          index++;
        }

        return -1;
    }
}
