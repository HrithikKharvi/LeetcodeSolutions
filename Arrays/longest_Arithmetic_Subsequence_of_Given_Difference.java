class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        if(arr.length <= 0)return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] contains = new int[arr.length];

        Arrays.fill(contains, 1);

        for(int i=0; i< arr.length; i++){
          int diff = arr[i] - difference;

          if(map.containsKey(diff)){
            int diffIndex = map.get(diff);
            contains[i] = contains[diffIndex] + 1;
          }

            map.put(arr[i], i);
        }

        for(int i=0; i< contains.length; i++){
          max = Math.max(max, contains[i]);
        }

        return max;
    }
}
