class Solution {
    public int maxSubArray(int[] nums) {
      int n = nums.length;

      if(n < 1)return 0;
      if(n == 1)return nums[0];
      int max = nums[n-1];
      int finalMax = max;

      for(int i=n-2; i>=0; i--){
        int currentSum = nums[i] + max;
        
        if(currentSum > nums[i]){
          max = currentSum;
          finalMax = Math.max(finalMax, max);
        }else{
          max = nums[i];
          finalMax = Math.max(finalMax, nums[i]);
        }
      }

      return finalMax;
    }
}
