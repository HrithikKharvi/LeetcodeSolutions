class Solution {
    public int rob(int[] nums) {
      int max = 0;
      Map<Integer,Integer> memo = new HashMap<Integer, Integer>();
      for(int i=0; i< nums.length; i++){
        System.out.println(memo);
        int currentMax = getResult(nums, i, memo);
        if(currentMax > max)max = currentMax;
      }
      return max;
    }

    public int getResult(int[] nums, int i,  Map<Integer,Integer> memo){
      if(memo.containsKey(i))return memo.get(i);
      int max = nums[i];

      for(int j=i+2; j< nums.length; j++){
        int currentMax = getResult(nums, j, memo);
        if(currentMax + nums[i] > max)max = currentMax + nums[i];
      }

      memo.put(i, max);
      return max;
    }
}
