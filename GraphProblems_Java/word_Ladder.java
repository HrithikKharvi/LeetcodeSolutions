class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> set = new HashSet<String>();

        for(String s : wordList){
          set.add(s);
        }

        set.remove(beginWord);
        queue.add(new Pair(beginWord, 1));

        while(queue.size() > 0){
          String word = queue.peek().getKey();
          int length = queue.peek().getValue();
          queue.remove();
          System.out.println("here!!");
          if(word.equals(endWord))return length;

          for(int i=0; i<word.length(); i++){
            for(char j = 'a'; j<='z'; j++){
              char[] charArr = word.toCharArray();
              charArr[i] = j;
              String replacedWord = new String(charArr);
              System.out.println(replacedWord);
              if(set.contains(replacedWord)){
                System.out.println(replacedWord);
                set.remove(replacedWord);
                queue.add(new Pair(replacedWord, length+1));
              }
            }
          }
        }

System.out.println("here");
        return 0;
    }
}
