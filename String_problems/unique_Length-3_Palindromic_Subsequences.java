class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] min = new int[26];
        int[] max = new int[26];

        int totCount = 0;

        for(int i=0; i<26; i++){
          min[i] = Integer.MAX_VALUE;
          max[i] = Integer.MIN_VALUE;
        }

        for(int i=0; i<s.length(); i++){
          int charIndex = s.charAt(i) - 'a';
          min[charIndex] = Math.min(min[charIndex], i);
          max[charIndex] = Math.max(max[charIndex], i);
        }

        for(int i=0; i<26; i++){
          if(min[i] == Integer.MAX_VALUE || max[i] == Integer.MIN_VALUE)continue;

          Set<Character> set = new HashSet<>();

          for(int k = min[i] + 1; k < max[i]; k++){
            set.add(s.charAt(k));
          }

          totCount += set.size();
        }

        return totCount;


    }
}
