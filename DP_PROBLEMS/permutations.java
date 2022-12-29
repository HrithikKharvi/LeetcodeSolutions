class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] map = new boolean[nums.length];

        findPermutation(nums, new ArrayList<Integer>(), map, list);

        return list;
    }

    public void findPermutation(int[] nums, ArrayList<Integer> currentArray, boolean[] map, List<List<Integer>> list){
        if(currentArray.size() == nums.length){
            ArrayList<Integer> newArray = new ArrayList<>();
            newArray = (ArrayList) currentArray.clone();
            list.add(newArray);
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!map[i]){
                currentArray.add(nums[i]);
                map[i] = true;
                findPermutation(nums, currentArray, map, list);
                map[i] = false;
                currentArray.remove(currentArray.size() - 1);
            }
        }

    }

}
