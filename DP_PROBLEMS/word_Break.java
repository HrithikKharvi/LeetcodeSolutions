class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      HashMap<Integer, Boolean> memo = new HashMap<>();
        return isBreaked(s, 0, wordDict, memo);
    }

    public boolean isBreaked(String s,int index, List<String> wordDict, Map<Integer, Boolean> memo){
      if(index >= s.length())return true;
      if(memo.containsKey(index))return memo.get(index);

      for(int i=0; i< wordDict.size(); i++){
        String word = wordDict.get(i);

        int start = index;
        int end = index + word.length();

        if(end > s.length())continue;

        if(s.substring(start, end).equals(word)){
          if(isBreaked(s, end, wordDict, memo))return true;
        }
      }

      memo.put(index, false);
      return false;
    }
}
