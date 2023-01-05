class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findCount(nums, 0, target, 0);
    }

    public int findCount(int[] nums, int index, int target, int currentSum){
        if(index == nums.length){
            if(currentSum == target)return 1;
            return 0;
        }

        int currentPlus = (-1) * nums[index];
        int currentMinus = nums[index];


        return findCount(nums, index+1, target, currentSum + currentMinus) + findCount(nums, index+1, target, currentSum + currentPlus);

    }

}
