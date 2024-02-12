class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums.length / 2;
        Arrays.sort(nums);
        int currentNum = Integer.MAX_VALUE;
        int count = 0;

        for(int i=0; i<nums.length; i++){
          if(currentNum != nums[i]){
            if(count > maj)return currentNum;
            currentNum = nums[i];
            count = 1;
          }else{
            count++;
          }
        }

        if(count > maj)return currentNum;

        return -1;
    }
}
