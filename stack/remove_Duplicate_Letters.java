class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[26];
        int[] lastIndex = new int[26];

        markLastIndex(lastIndex, s);

        for(int i=0; i<s.length(); i++){
          int ch = s.charAt(i) - 'a';
          if(visited[ch] == 1)continue;
          while(!stack.isEmpty() && stack.peek() > ch && i < lastIndex[stack.peek()]){
              visited[stack.pop()] = 0;
          }
            stack.add(ch);
            visited[ch] = 1;

        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty())sb.append((char)(stack.pop() + 'a'));

        return sb.reverse().toString();

    }

    public void markLastIndex(int[] lastIndex, String s){
      for(int i=0; i<s.length(); i++){
        char ch = s.charAt(i);
        lastIndex[ch - 'a'] = i;
      }
    }

}
