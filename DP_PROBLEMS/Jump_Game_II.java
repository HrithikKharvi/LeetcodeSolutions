class Solution {
    public int jump(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return findMinimum(nums, 0, 0, nums.length-1, memo);
    }

    public int findMinimum(int[] nums, int i, int count, int target, Map<Integer,Integer> memo){
      if(memo.containsKey(i))return memo.get(i);
      if(i == target){
          System.out.println(i + "L " + count);
        return 0;
      }
      if(i > target)return -1;
      int minimum = Integer.MAX_VALUE;
      int currentJump = nums[i];
      
      for(int j=1; j<=currentJump; j++){
        int currentMin = findMinimum(nums, i+j, count+1, target, memo);
        if(currentMin != -1 && currentMin < minimum)minimum = currentMin+1;
      }

      memo.put(i,minimum);

      return minimum;

    }

}
