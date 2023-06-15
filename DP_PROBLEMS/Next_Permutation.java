class Solution {
    public void nextPermutation(int[] nums) {

      int breakerIndex = findBreakPoint(nums);
      if(breakerIndex == -1){
        reverseElements(nums, 0, nums.length-1);
        return;
      }

      int nextSmall = findNextSmall(nums, breakerIndex);

      swap(nums, breakerIndex, nextSmall);

      reverseElements(nums, breakerIndex+1, nums.length-1);
    }

    public int findBreakPoint(int[] nums){
      int index = -1;

      for(int i=nums.length-2; i >= 0; i--){
        if(nums[i] < nums[i+1])return i;
      }

      return index;
    }

    public int findNextSmall(int[] nums, int breaker){
      for(int i=nums.length-1; i>breaker; i--){
        if(nums[i] > nums[breaker])return i;
      }

      return -1;
    }

    public void reverseElements(int[] nums, int start, int end){
      while(start < end){

        swap(nums, start, end);

        start++;
        end--;
      }
    }

    public void swap(int[] nums, int i, int j){
      int temp = nums[i];

      nums[i] = nums[j];
      nums[j] = temp;
    }


}
