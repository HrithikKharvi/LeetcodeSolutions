class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = findMinCount(coins, amount, map);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int findMinCount(int[] coins, int sum, Map<Integer, Integer> map){
      if(sum == 0)return 0;
      if(map.containsKey(sum))return map.get(sum);

      int minCount = Integer.MAX_VALUE;
      for(int i=0; i< coins.length; i++){
       if(coins[i] > sum)continue;
       minCount = Math.min(minCount, findMinCount(coins, sum-coins[i], map));
      }
       minCount = minCount == Integer.MAX_VALUE ? Integer.MAX_VALUE : minCount+1;
       map.put(sum, minCount);
       return minCount;
    }
}
