class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        findSubs(nums, list);
        return list;
    }

    public void findSubs(int[] nums, List<List<Integer>> result){
      int max = 1 << nums.length;

      for(int i=0; i<max; i++){
        formList(result, nums, i);
      }
    }

    public void formList(List<List<Integer>> result, int[] nums, int i){
      int index = 0;
      List<Integer> set = new ArrayList<>();

      for(int k=i; k>0; k = k >> 1){
        if((k&1) == 1)set.add(nums[index]);
        index++;
      }

      result.add(set);
    }
}
