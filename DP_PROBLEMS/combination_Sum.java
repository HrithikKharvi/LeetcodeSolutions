class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findCombination(candidates, target, 0, list, 0, new ArrayList<Integer>());
        return list;
    }

    public void findCombination(int[] nums, int target, int index, List<List<Integer>> list, int currentSum, ArrayList<Integer> currentList){
        if(index == nums.length || currentSum > target){
            return;
        }

        if(currentSum == target){
                ArrayList<Integer> newArrayList = new ArrayList<>();
                newArrayList = (ArrayList)currentList.clone();
                list.add(newArrayList);
                System.out.println(list);

                return;
        }



        currentList.add(nums[index]);
        currentSum += nums[index];

        findCombination(nums, target, index, list, currentSum, currentList);

        currentList.remove(currentList.size()-1);
        currentSum -= nums[index];

        findCombination(nums, target,index+1, list, currentSum, currentList);

    }

}
