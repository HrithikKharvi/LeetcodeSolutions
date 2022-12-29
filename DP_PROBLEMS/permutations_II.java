class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        boolean[] map = new boolean[nums.length];
        findPermutation(nums, new ArrayList<Integer>(), map, set);

        List<List<Integer>> arr = new ArrayList<>();
        Iterator<List<Integer>> it = set.iterator();

        for(int i=0; i<set.size(); i++){
            if(it.hasNext()){
                arr.add(it.next());
            }
        }

        return arr;
    }

    public void findPermutation(int[] nums, ArrayList<Integer> currentList, boolean[] map, Set<List<Integer>> list){
        if(currentList.size() == nums.length){
            ArrayList<Integer> newList = new ArrayList<>();
            newList = (ArrayList) currentList.clone();
            list.add(newList);
            return;
        }

        for(int i=0; i< nums.length; i++){
            if(!map[i]){
                map[i] = true;
                currentList.add(nums[i]);
                findPermutation(nums, currentList, map, list);

                map[i] = false;
                currentList.remove(currentList.size() - 1);
            }
        }

    }

}
