class Solution {
    public int minCostClimbingStairs(int[] cost) {
      if(cost.length == 0)return 0;
      if(cost.length == 1)return cost[0];
      int[] memo = new int[cost.length];
      Arrays.fill(memo, -1);
        int oneStep = climbStair(0, cost, memo);
        int twoStep = climbStair(1, cost, memo);

        return oneStep < twoStep ? oneStep : twoStep;
    }

    public int climbStair(int index, int[] cost, int[] memo){
      if(index >= cost.length)return 0;
      if(memo[index] != -1)return memo[index];

      int oneStep = climbStair(index+1, cost, memo) + cost[index];
      int twoStep = climbStair(index+2, cost, memo) + cost[index];

      memo[index] = oneStep < twoStep ? oneStep : twoStep;
      return memo[index];

    }

}
