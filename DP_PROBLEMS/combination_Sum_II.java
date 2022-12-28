class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(candidates);
        findCombination(candidates, 0, target, list, new ArrayList<Integer>(), 0);

        return list;
    }

    public void findCombination(int[] nums, int index, int target, List<List<Integer>> list, ArrayList<Integer> currentList, int currentSum){
      if(index == nums.length){
        if(currentSum == target){
          List<Integer> newList = new ArrayList<>();
          newList = (ArrayList) currentList.clone();
          list.add(newList);
        }
        return;
      }
      if(currentSum > target)return;
      if(currentSum == target){
        List<Integer> newList = new ArrayList<>(currentList);
        list.add(newList);
        return;
      }

      for(int i=index; i< nums.length; i++){
        if(i > index && nums[i] == nums[i-1])continue;
        currentList.add(nums[i]);
        int tempSum = currentSum + nums[i];
        // if(tempSum > target)break;
        findCombination(nums, i+1, target, list, currentList, currentSum + nums[i]);
        currentList.remove(currentList.size() - 1);
      }

    }

}
