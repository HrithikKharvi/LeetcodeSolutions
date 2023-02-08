class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 2)return Math.max(nums[0], nums[1]) == nums[0] ? 0 : 1;
        if(nums.length == 1)return 0;
        if(nums.length == 0)return -1;
        int start = 0;

        int index = -1;
        while(start < nums.length-1){
          if(start == 0 && nums[start] > nums[start+1]){
            index = start;
            start++;
            continue;
          }
          if(start > 0 && nums[start] > nums[start-1] && nums[start] > nums[start+1])index = start;
          start++;
        }

        if(start == nums.length-1 && nums[start] > nums[start-1])index = start;

        return index;
    }
}
