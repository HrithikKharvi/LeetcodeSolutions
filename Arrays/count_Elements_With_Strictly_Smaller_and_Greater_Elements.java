class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int smaller = nums[0];
        int greater = nums[nums.length-1];

        for(int i=1; i< nums.length-1; i++){
          if(nums[i] > smaller && nums[i] < greater)count++;
        }

        return count;
    }
}
