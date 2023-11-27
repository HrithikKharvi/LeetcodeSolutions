class Solution {
    public int distinctAverages(int[] nums) {
        //sort
        //create set to avoid duplicates
        //return the size of the set

        Arrays.sort(nums);

        Set<Double> set = new HashSet<>();

        int i = 0;
        int j = nums.length - 1;

        while(i < j){

          int sum = nums[i] + nums[j];

          set.add(((double)sum / 2));

          i++;
          j--;
        }

        return set.size();

    }
}
