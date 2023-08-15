//first check whether we have enough elements for checking the condition
//in the next step check for all the three conditions
//check whether all the 3 values from the given index are same.
//check whether all the 2 values from the given index are same.
//check whether all the 3 values have the difference of 1.
//in any one of them passes call the function by pushing the pointer to the right with proper count according the condition that we checked
//check whether any of the three condition check and function call will take us to the end of the array.
//if any of the condition meets the requirement return true

class Solution {
    public boolean validPartition(int[] nums) {
      Map<Integer, Boolean> hashMap = new HashMap<>();
        int n = nums.length;
        return findIsValid(nums, 0, n, hashMap);
    }

    public boolean findIsValid(int[] nums, int index, int n, Map<Integer, Boolean> memo){
      if(index >= n)return true;
      if(memo.containsKey(index))return memo.get(index);

      boolean isValid = false;

      if(index + 2 < n){
        if(nums[index] == nums[index+1] && nums[index+1] == nums[index+2])
        isValid = findIsValid(nums, index+3, n, memo);
      }

      if(isValid)return true;
      if(index+1 < n){
       if(nums[index] == nums[index+1])
       isValid = findIsValid(nums, index+2, n, memo);
      }
      if(isValid)return true;
      if(index+2 < n){
       
       if(nums[index]+1 == nums[index+1] && nums[index+1] + 1 == nums[index+2])
       isValid = findIsValid(nums, index+3, n, memo);
      }

      memo.put(index, isValid);

      return isValid;
    }

}
